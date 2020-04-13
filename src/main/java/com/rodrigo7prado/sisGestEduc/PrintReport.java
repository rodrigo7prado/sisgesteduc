package com.rodrigo7prado.sisGestEduc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

public class PrintReport extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void showReport() throws JRException, ClassNotFoundException, SQLException {
 
//        String reportSrcFile = "MyReports/Blank_A4.jrxml";
        String reportSrcFile = "MyReports/Certidaojrxml.jrxml";
 
        // First, compile jrxml file.
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);
        // Fields for report
        HashMap<String, Object> parameters = new HashMap<String, Object>();
 
//        parameters.put("company", "MAROTHIA TECHS");
//        parameters.put("receipt_no", "RE101".toString());
//        parameters.put("name", "Khushboo");
//        parameters.put("amount", "10000");
//        parameters.put("receipt_for", "EMI Payment");
//        parameters.put("date", "20-12-2016");
//        parameters.put("contact", "98763178".toString());
        
        parameters.put("nfl", new String());
        parameters.put("a_corrigir", new String());
        parameters.put("aluno", new String());
        parameters.put("ano", new String());
        parameters.put("carga_horaria_modalidade", new String());
        parameters.put("censo", new String());
        parameters.put("cn_cartorio", new String());
        parameters.put("cn_emissao", new String());
        parameters.put("cn_folha", new String());
   		parameters.put("cn_livro", new String());
		parameters.put("cn_municipio", new String());
		parameters.put("cn_termo", new String());
		parameters.put("cn_uf", new String());
        parameters.put("consolidado_modalidade", new String());
        parameters.put("corrigido", new String());
        parameters.put("curso", new String());
        parameters.put("data_conclusao", new String());
        parameters.put("data_emissao_certificado", new String());
        parameters.put("data_inst_ato_de_criacao", new String());
        parameters.put("data_nasc", new String());
        parameters.put("decreto_modalidade", new String());
        parameters.put("descr_erro", new String());
        parameters.put("doc_concl_modalidades_modalidade", new String());
        parameters.put("impresso", new String());
        parameters.put("imprimir_agora", new String());
        parameters.put("inst_ato_de_criacao", new String());
        parameters.put("instituicao", new String());
        parameters.put("lei_modalidade", new String());
        parameters.put("livro", new String());
        parameters.put("mae", new String());
        parameters.put("nacionalidade", new String());
        parameters.put("naturalidade", new String());
        parameters.put("naturalidade_uf", new String());
        parameters.put("nome_compl", new String());
        parameters.put("pai", new String());
        parameters.put("reimpresso", new String());
        parameters.put("rg", new String());
        parameters.put("rg_emissao", new String());
        parameters.put("rg_emissor", new String());
        parameters.put("rg_emissor_uf", new String());
        parameters.put("sexo", new String());
        parameters.put("situacao_final", new String());
        parameters.put("tipo_doc", new String());
        parameters.put("turma", new String());
		
	
        
        
        
        
        
 
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        list.add(parameters);
        list.add(parameters);
        
//        new JRBeanCollectionDataSource()
        
 
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(list);
        JasperPrint print = JasperFillManager.fillReport(jasperReport, null, beanColDataSource);
        JRViewer viewer = new JRViewer(print);
        viewer.setOpaque(true);
        viewer.setVisible(true);
        this.add(viewer);
        this.setSize(700, 500);
        this.setVisible(true);
        System.out.print("Done!");
 
    }

}