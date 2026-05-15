package com.oakdev.sistema_academia.repository;

import com.oakdev.sistema_academia.model.FaturaMatricula;
import com.oakdev.sistema_academia.projection.AlunosPorCidadeProjection;
import com.oakdev.sistema_academia.projection.FaturamentoMensalProjection;
import com.oakdev.sistema_academia.projection.FaturasEmAbertoProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface RelatorioAcademiaRepository extends Repository<FaturaMatricula, Long> {

    @Query(
            value = """
                    SELECT
                        TO_CHAR(data_vencimento, 'YYYY-MM') AS mes,
                        SUM(valor) as total
                    FROM faturas_matriculas
                    WHERE status= 'PAGA'
                    GROUP BY TO_CHAR(data_vencimento, 'YYYY-MM')
                    ORDER BY mes
                    """,
            nativeQuery = true
    )
    List<FaturamentoMensalProjection> faturamentoMensal();


    @Query(
            value = """
                    SELECT
                        cidade,
                        count(*) as quantidade
                    FROM alunos
                    GROUP BY cidade
                    ORDER BY quantidade desc
                    """,
            nativeQuery = true
    )
    List<AlunosPorCidadeProjection> alunosPorCidade();



    @Query(
            value = """
                    SELECT
                        m.id as matriculaId,
                        a.nome AS alunoNome,
                        f.data_vencimento as data_vencimento,
                        f.valor
                    FROM faturas_matriculas f
                    JOIN matriculas M on m.id = f.matricula_id
                    JOIN alunos a ON a.id = m.aluno_id
                    WHERE f.status = 'Aberta'
                    ORDER BY data_vencimento desc
                    """,
            nativeQuery = true
    )
    List<FaturasEmAbertoProjection> faturasEmAberto();

}
