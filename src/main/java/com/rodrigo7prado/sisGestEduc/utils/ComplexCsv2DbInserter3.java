package com.rodrigo7prado.sisGestEduc.utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseBool;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import com.rodrigo7prado.sisGestEduc.entities.external.AlunoExternal3;

public class ComplexCsv2DbInserter3 {

	private String jdbcURL = "jdbc:mysql://localhost:3307/sisgesteduc?useTimezone=true&serverTimezone=UTC";
	private String username = "root";
	private String password = "";

	private String csvFilePath = "consolidado_manual_aluno.csv";
	private Connection connection = null;

	ICsvBeanReader beanReader = null;
	CellProcessor[] processors = new CellProcessor[] { new NotNull(), //1 NOME_COMPL
			new NotNull(), //2 ALUNO
			new Optional(), //3 Status_Matricula_Conex
			new ParseBool(), //4 Certificação
			new Optional(new ParseDate("dd/MM/yyyy HH:mm:ss")), //5 Data_conclusao_EM
			new Optional(new ParseDate("dd/MM/yyyy HH:mm:ss")), //6 Data_nasc
			new Optional(), //7 Pai
			new Optional(), //8 Mae
			new Optional(), //9 sexo
			new Optional(), //10 nacionalidade
			new Optional(), //11 naturalidadeUF
			new Optional(), //12 naturalidade
			new Optional(), //13 rg
			new Optional(), //14 rg_emissor
			new Optional(), //15 rg_emissor_UF
			new Optional(), //16 rg_emissao
			new Optional(), //17 CN_Cartorio
			new Optional(), //18 CN_Municipio
			new Optional(), //19 CN_UF
			new Optional(), //20 CN_TERMO
			new Optional(), //21 CN_LIVRO
			new Optional(), //22 CN_FOLHA
			new Optional(), //23 CN_EMISSAO
			new ParseBool(), //24 dyn_mais_de_um_curso
			new Optional(), //25 OBS_HIST
			new Optional(), //26 OBS_HIST_1
			new Optional(), //27 OBS_HIST_2
			new ParseBool(), //28 Falta_HE_Fundamental
			new ParseBool(), //29 Falta_HE_Medio
			new ParseBool(), //30 Falta_Rg
			new ParseBool(), //31 Falta_CN
			new ParseBool(), //32 DADOS_CONFERIDOS
			new ParseBool(), //33 Mais_de_um_curso
			new Optional(), //34 EF_Escola_conc
			new Optional(), //35 EF_Escola_conc_Local
			new Optional(), //36 EF_Ano_Conc
			new Optional(), //37 EF_Conc_Emissao
			new Optional(), //38 EF_num_pag
			new Optional(), //39 Cidade_Estado_Escola
			new Optional(), //40 Ultima_Modalidade
			new Optional(), //41 Ultimo_ano
			new Optional(), //42 Ultima_turma
			new Optional(), //43 Ultimo_Resultado_Final
			new Optional(), //44 Res_Serie_1
			new Optional(), //45 Res_Serie_2
			new Optional(), //46 Res_Serie_3
			new Optional(), //47 Res_Serie_4
			new Optional(), //48 Res_Serie_1_subst
			new Optional(), //49 Res_Serie_2_subst
			new Optional(), //50 Res_Serie_3_subst
			new Optional(), //51 Res_Serie_4_subst
			new Optional(), //52 Ano_Serie_1
			new Optional(), //53 Ano_Serie_2
			new Optional(), //54 Ano_Serie_3
			new Optional(), //55 Ano_Serie_4
			new Optional(), //56 Turma_Serie_1
			new Optional(), //57 Turma_Serie_2
			new Optional(), //58 Turma_Serie_3
			new Optional(), //59 Turma_Serie_4
			new Optional(), //60 FrqG_1
			new Optional(), //61 FrqG_2
			new Optional(), //62 FrqG_3
			new Optional(), //63 FrqG_4
			new Optional(), //64 CH_subst_1
			new Optional(), //65 CH_subst_2
			new Optional(), //66 CH_subst_3
			new Optional(), //67 CH_subst_4
			new Optional(), //68 Freq_Subst_1
			new Optional(), //69 Freq_Subst_2
			new Optional(), //70 Freq_Subst_3
			new Optional(), //71 Freq_Subst_4
			new Optional(), //72 EnsMedio_EstabEns_Ano_1
			new Optional(), //73 EnsMedio_EstabEns_Ano_2
			new Optional(), //74 EnsMedio_EstabEns_Ano_3
			new Optional(), //75 EnsMedio_EstabEns_Ano_4
			new Optional(), //76 EnsMedio_CidadeEstado_EstabEns_Ano_1
			new Optional(), //77 EnsMedio_CidadeEstado_EstabEns_Ano_2
			new Optional(), //78 EnsMedio_CidadeEstado_EstabEns_Ano_3
			new Optional(), //79 EnsMedio_CidadeEstado_EstabEns_Ano_4
			
			// new NotNull(), // student name
			// new ParseTimestamp(), // timestamp
			// new ParseDouble(), // rating
			// new Optional()// comment
	};

	public ComplexCsv2DbInserter3() {
//		System.out.println("Optional class" + Optional.class.getClass());
//		Optional.class.
		int batchSize = 20;
		try {
			long start = System.currentTimeMillis();

			connection = DriverManager.getConnection(jdbcURL, username, password);
			connection.setAutoCommit(false);

//			String sql = "INSERT INTO consolidado_manual_alunos (nome_completo,ALUNO,Data_conclusao_EM,Data_nasc,Pai,Mae,sexo,nacionalidade,naturalidadeUF,naturalidade,rg,rg_emissor,rg_emissor_UF,rg_emissao,CN_Cartorio,CN_Municipio,CN_UF,CN_TERMO,CN_LIVRO,CN_FOLHA,CN_EMISSAO,OBS_HIST,Falta_HE_Fundamental,Falta_HE_Medio,Falta_Rg,Falta_CN,DADOS_CONFERIDOS,EF_Escola_conc,EF_Escola_conc_Local,EF_Ano_Conc,EF_Conc_Emissao,EF_num_pag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			String sql = "INSERT INTO consolidado_manual_alunos (NOME_COMPL,ALUNO,Status_Matricula_Conex,certificacao,data_conclusao_em,Data_nasc,nome_pai,nome_mae,sexo,nacionalidade,naturalidadeUF,naturalidade,rg,rg_emissor,rg_emissor_uf,rg_data_emissao,cn_cartorio,cn_municipio,cnuf,cn_termo,cn_livro,cn_folha,cn_data_emissao,dyn_mais_de_um_curso,obs_hist,obs_hist1,obs_hist2,falta_entrega_he_fundamental,falta_entrega_he_medio,falta_entrega_rg,falta_entrega_cn,dados_conferidos,mais_de_um_curso,ens_fund_escola_conclusao,ens_fund_municipio_escola_conclusao,ens_fund_ano_escola_conclusao,ens_fund_data_emissao_conclusao,ens_fund_num_paginas_conclusao,cidade_estado_escola,ultima_modalidade,ultimo_ano,ultima_turma,ultimo_resultado_final,res_serie1,res_serie2,res_serie3,res_serie4,res_serie1subst,res_serie2subst,res_serie3subst,res_serie4subst,ano_serie1,ano_serie2,ano_serie3,ano_serie4,turma_serie1,turma_serie2,turma_serie3,turma_serie4,frqg1,frqg2,frqg3,frqg4,ch_subst1,ch_subst2,ch_subst3,ch_subst4,freq_subst1,freq_subst2,freq_subst3,freq_subst4,ens_medio_estab_ens_ano1,ens_medio_estab_ens_ano2,ens_medio_estab_ens_ano3,ens_medio_estab_ens_ano4,ens_medio_cidade_estado_estab_ens_ano1,ens_medio_cidade_estado_estab_ens_ano2,ens_medio_cidade_estado_estab_ens_ano3,ens_medio_cidade_estado_estab_ens_ano4) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);

			beanReader = new CsvBeanReader(new FileReader(csvFilePath), CsvPreference.STANDARD_PREFERENCE);

			beanReader.getHeader(true); // skip header line

//			String[] header = { "courseName", "studentName", "timestamp", "rating", "comment" };
//			String[] header = { "NOME_COMPL", "ALUNO", "Data_conclusao_EM", "Data_nasc", "Pai", "Mae", "sexo",
//					"nacionalidade", "naturalidadeUF", "naturalidade", "rg", "rg_emissor", "rg_emissor_UF",
//					"rg_emissao", "CN_Cartorio", "CN_Municipio", "CN_UF", "CN_TERMO", "CN_LIVRO", "CN_FOLHA",
//					"CN_EMISSAO", "OBS_HIST", "Falta_HE_Fundamental", "Falta_HE_Medio", "Falta_Rg", "Falta_CN",
//					"DADOS_CONFERIDOS", "EF_Escola_conc", "EF_Escola_conc_Local", "EF_Ano_Conc", "EF_Conc_Emissao",
//					"EF_num_pag" };
			String[] header = { "nomeCompleto", "matricula", "statusMatriculaConexao", "certificacao", "dataConclusaoEM", "dataNasc","nomePai","nomeMae","sexo","nacionalidade","naturalidadeUF","naturalidade","rg","rgEmissor","rgEmissorUf","rgDataEmissao","cnCartorio","cnMunicipio","cnUF","cnTermo","cnLivro","cnFolha","cnDataEmissao","dyn_mais_de_um_curso","obsHist","obsHist1","obsHist2","faltaEntregaHEFundamental","faltaEntregaHEMedio","faltaEntregaRG","faltaEntregaCN","dadosConferidos","maisDeUmCurso","ensFundEscolaConclusao","ensFundMunicipioEscolaConclusao","ensFundAnoEscolaConclusao","ensFundDataEmissaoConclusao","ensFundNumPaginasConclusao","cidadeEstadoEscola","ultimaModalidade","ultimoAno","ultimaTurma","ultimoResultadoFinal","resSerie1","resSerie2","resSerie3","resSerie4","resSerie1Subst","resSerie2Subst","resSerie3Subst","resSerie4Subst","anoSerie1","anoSerie2","anoSerie3","anoSerie4","turmaSerie1","turmaSerie2","turmaSerie3","turmaSerie4","frqG1","frqG2","frqG3","frqG4","chSubst1","chSubst2","chSubst3","chSubst4","freqSubst1","freqSubst2","freqSubst3","freqSubst4","ensMedioEstabEnsAno1","ensMedioEstabEnsAno2","ensMedioEstabEnsAno3","ensMedioEstabEnsAno4","ensMedioCidadeEstadoEstabEnsAno1","ensMedioCidadeEstadoEstabEnsAno2","ensMedioCidadeEstadoEstabEnsAno3","ensMedioCidadeEstadoEstabEnsAno4"};
			
			AlunoExternal3 bean = null;

			int count = 0;

			while ((bean = beanReader.read(AlunoExternal3.class, header, processors)) != null) {
				String nomeCompleto = bean.getNomeCompleto();
				String matricula = bean.getMatricula();
				String statusMatriculaConexao = bean.getStatusMatriculaConexao();
				Boolean certificacao = bean.getCertificacao();
				Date DataConclusaoEM = bean.getDataConclusaoEM();
				Date Data_nasc = bean.getDataNasc();
				String nomePai = bean.getNomePai();
				String nomeMae = bean.getNomeMae();
				String sexo = bean.getSexo();
				String nacionalidade = bean.getNacionalidade();
				String naturalidadeUF = bean.getNaturalidadeUF();
				String naturalidade = bean.getNaturalidade();
				String rg = bean.getRg();
				String rgEmissor = bean.getRgEmissor();
				String rgEmissorUf = bean.getRgEmissorUf();
				String rgDataEmissao = bean.getRgDataEmissao();
				String cnCartorio = bean.getCnCartorio();
				String cnMunicipio = bean.getCnMunicipio();
				String cnUF = bean.getCnUF();
				String cnTermo = bean.getCnTermo();
				String cnLivro = bean.getCnLivro();
				String cnFolha = bean.getCnFolha();
				String cnDataEmissao = bean.getCnDataEmissao();
				Boolean dyn_mais_de_um_curso = bean.getDyn_mais_de_um_curso();
				String obsHist = bean.getObsHist();
				String obsHist1 = bean.getObsHist1();
				String obsHist2 = bean.getObsHist2();
				Boolean faltaEntregaHeFundamental = bean.getFaltaEntregaHeFundamental();
				Boolean faltaEntregaHeMedio = bean.getFaltaEntregaHeMedio();
				Boolean faltaEntregaRg = bean.getFaltaEntregaRg();
				Boolean faltaEntregaCn = bean.getFaltaEntregaCn();
				Boolean dadosConferidos = bean.getDadosConferidos();
				Boolean maisDeUmCurso = bean.getMaisDeUmCurso();
				String ensFundEscolaConclusao = bean.getEnsFundEscolaConclusao();
				String ensFundMunicipioEscolaConclusao = bean.getEnsFundMunicipioEscolaConclusao();
				String ensFundAnoEscolaConclusao = bean.getEnsFundAnoEscolaConclusao();
				String ensFundDataEmissaoConclusao = bean.getEnsFundDataEmissaoConclusao();
				String ensFundNumPaginasConclusao = bean.getEnsFundNumPaginasConclusao();
				String cidadeEstadoEscola = bean.getCidadeEstadoEscola();
				String ultimaModalidade = bean.getUltimaModalidade();
				String ultimoAno = bean.getUltimoAno();
				String ultimaTurma = bean.getUltimaTurma();
				String ultimoResultadoFinal = bean.getUltimoResultadoFinal();
				String resSerie1 = bean.getResSerie1();
				String resSerie2 = bean.getResSerie2();
				String resSerie3 = bean.getResSerie3();
				String resSerie4 = bean.getResSerie4();
				String resSerie1Subst = bean.getResSerie1Subst();
				String resSerie2Subst = bean.getResSerie2Subst();
				String resSerie3Subst = bean.getResSerie3Subst();
				String resSerie4Subst = bean.getResSerie4Subst();
				String anoSerie1 = bean.getAnoSerie1();
				String anoSerie2 = bean.getAnoSerie2();
				String anoSerie3 = bean.getAnoSerie3();
				String anoSerie4 = bean.getAnoSerie4();
				String turmaSerie1 = bean.getTurmaSerie1();
				String turmaSerie2 = bean.getTurmaSerie2();
				String turmaSerie3 = bean.getTurmaSerie3();
				String turmaSerie4 = bean.getTurmaSerie4();
				String frqG1 = bean.getFrqG1();
				String frqG2 = bean.getFrqG2();
				String frqG3 = bean.getFrqG3();
				String frqG4 = bean.getFrqG4();
				String chSubst1 = bean.getChSubst1();
				String chSubst2 = bean.getChSubst2();
				String chSubst3 = bean.getChSubst3();
				String chSubst4 = bean.getChSubst4();
				String freqSubst1 = bean.getFreqSubst1();
				String freqSubst2 = bean.getFreqSubst2();
				String freqSubst3 = bean.getFreqSubst3();
				String freqSubst4 = bean.getFreqSubst4();
				String ensMedioEstabEnsAno1 =  bean.getEnsMedioEstabEnsAno1();
				String ensMedioEstabEnsAno2 =  bean.getEnsMedioEstabEnsAno2();
				String ensMedioEstabEnsAno3 =  bean.getEnsMedioEstabEnsAno3();
				String ensMedioEstabEnsAno4 =  bean.getEnsMedioEstabEnsAno4();
				String ensMedioCidadeEstadoEstabEnsAno1 = bean.getEnsMedioCidadeEstadoEstabEnsAno1();
				String ensMedioCidadeEstadoEstabEnsAno2 = bean.getEnsMedioCidadeEstadoEstabEnsAno2();
				String ensMedioCidadeEstadoEstabEnsAno3 = bean.getEnsMedioCidadeEstadoEstabEnsAno3();
				String ensMedioCidadeEstadoEstabEnsAno4 = bean.getEnsMedioCidadeEstadoEstabEnsAno4();
				
				
//				System.out.println("Data_nasc: " + Data_nasc);
				
				if (DataConclusaoEM != null) {
					DataConclusaoEM = new java.sql.Date(DataConclusaoEM.getTime());
				}
				
				if (Data_nasc != null) {
					Data_nasc = new java.sql.Date(Data_nasc.getTime());
				}

				statement.setString(1, nomeCompleto);
				statement.setString(2, matricula);
				statement.setString(3, statusMatriculaConexao);
				statement.setBoolean(4, certificacao);
				statement.setDate(5, (java.sql.Date) DataConclusaoEM);
				statement.setDate(6, (java.sql.Date) Data_nasc );
				statement.setString(7, nomePai);
				statement.setString(8, nomeMae);
				statement.setString(9, sexo);
				statement.setString(10, nacionalidade);
				statement.setString(11, naturalidadeUF);
				statement.setString(12, naturalidade);
				statement.setString(13, rg);
				statement.setString(14, rgEmissor);
				statement.setString(15, rgEmissorUf);
				statement.setString(16, rgDataEmissao);
				statement.setString(17, cnCartorio);
				statement.setString(18, cnMunicipio);
				statement.setString(19, cnUF);
				statement.setString(20, cnTermo);
				statement.setString(21, cnLivro);
				statement.setString(22, cnFolha);
				statement.setString(23, cnDataEmissao);				
				statement.setBoolean(24, dyn_mais_de_um_curso);
				statement.setString(25, obsHist);
				statement.setString(26, obsHist1);
				statement.setString(27, obsHist2);
				statement.setBoolean(28, faltaEntregaHeFundamental);
				statement.setBoolean(29, faltaEntregaHeMedio);
				statement.setBoolean(30, faltaEntregaRg);
				statement.setBoolean(31, faltaEntregaCn);
				statement.setBoolean(32, dadosConferidos);
				statement.setBoolean(33, maisDeUmCurso);
				statement.setString(34, ensFundEscolaConclusao);
				statement.setString(35, ensFundMunicipioEscolaConclusao);				
				statement.setString(36, ensFundAnoEscolaConclusao);
				statement.setString(37, ensFundDataEmissaoConclusao);
				statement.setString(38, ensFundNumPaginasConclusao);
				statement.setString(39, cidadeEstadoEscola);
				statement.setString(40, ultimaModalidade);
				statement.setString(41, ultimoAno);
				statement.setString(42, ultimaTurma);
				statement.setString(43, ultimoResultadoFinal);
				statement.setString(44, resSerie1);
				statement.setString(45, resSerie2);
				statement.setString(46, resSerie3);
				statement.setString(47, resSerie4);
				statement.setString(48, resSerie1Subst);
				statement.setString(49, resSerie2Subst);
				statement.setString(50, resSerie3Subst);
				statement.setString(51, resSerie4Subst);
				statement.setString(52, anoSerie1);
				statement.setString(53, anoSerie2);
				statement.setString(54, anoSerie3);
				statement.setString(55, anoSerie4);
				statement.setString(56, turmaSerie1);
				statement.setString(57, turmaSerie2);
				statement.setString(58, turmaSerie3);
				statement.setString(59, turmaSerie4);
				statement.setString(60, frqG1);
				statement.setString(61, frqG2);
				statement.setString(62, frqG3);
				statement.setString(63, frqG4);
				statement.setString(64, chSubst1);
				statement.setString(65, chSubst2);
				statement.setString(66, chSubst3);
				statement.setString(67, chSubst4);
				statement.setString(68, freqSubst1);
				statement.setString(69, freqSubst2);
				statement.setString(70, freqSubst3);
				statement.setString(71, freqSubst4);
				statement.setString(72, ensMedioEstabEnsAno1);
				statement.setString(73, ensMedioEstabEnsAno2);
				statement.setString(74, ensMedioEstabEnsAno3);
				statement.setString(75, ensMedioEstabEnsAno4);
				statement.setString(76, ensMedioCidadeEstadoEstabEnsAno1);
				statement.setString(77, ensMedioCidadeEstadoEstabEnsAno2);
				statement.setString(78, ensMedioCidadeEstadoEstabEnsAno3);
				statement.setString(79, ensMedioCidadeEstadoEstabEnsAno4);
				
				
				statement.setString(1, nomeCompleto);
				statement.setString(2, matricula);
				statement.setString(3, statusMatriculaConexao);
				statement.setBoolean(4, certificacao);
				statement.setDate(5, (java.sql.Date) DataConclusaoEM);
				statement.setDate(6, (java.sql.Date) Data_nasc);
								
//				statement.setString(5, Pai);
//				statement.setString(6, Mae);
//				statement.setString(7, sexo);
//				statement.setString(8, nacionalidade);
//				statement.setString(9, naturalidadeUF);
//				statement.setString(10, naturalidade);
//				statement.setString(11, rg);
//				statement.setString(12, rg_emissor);
//				statement.setString(13, rg_emissor_UF);
//				statement.setString(14, rg_emissao);
//				statement.setString(15, CN_Cartorio);
//				statement.setString(16, CN_Municipio);
//				statement.setString(17, CN_UF);
//				statement.setString(18, CN_TERMO);
//				statement.setString(19, CN_LIVRO);
//				statement.setString(20, CN_FOLHA);
//				statement.setString(21, CN_EMISSAO);
//				statement.setString(22, OBS_HIST);
//				statement.setBoolean(23, Falta_HE_Fundamental);
//				statement.setBoolean(24, Falta_HE_Medio);
//				statement.setBoolean(25, Falta_Rg);
//				statement.setBoolean(26, Falta_CN);
//				statement.setBoolean(27, DADOS_CONFERIDOS);
//				statement.setString(28, EF_Escola_conc);
//				statement.setString(29, EF_Escola_conc_Local);
//				statement.setString(30, EF_Ano_Conc);
//				statement.setString(31, EF_Conc_Emissao);
//				statement.setString(32, EF_num_pag);
				statement.addBatch();

				if (count % batchSize == 0) {
					statement.executeBatch();
				}
			}

			System.out.println("AAAA");
			
			beanReader.close();

			// execute the remaining queries
			statement.executeBatch();

			connection.commit();
			connection.close();

			long end = System.currentTimeMillis();
			System.out.println("Execution Time: " + (end - start));
		} catch (IOException ex) {
			System.err.println(ex);
		} catch (SQLException ex) {
			ex.printStackTrace();

			try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
