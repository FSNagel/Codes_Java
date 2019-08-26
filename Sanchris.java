import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.sql.*;

public class Sanchris implements ActionListener{

	public JFrame frame;
	public JButton botao;
	public JPanel panelWest;
	public JPanel panelCenter;
	public JLabel labelBemVindo,
	labelTabela,
	labelVazia;
	public JButton botaoInsert,
	botaoDelete,
	botaoUpdate,
	botaoExecutar,
	botaoBegin,
	botaoCommit,
	botaoRollback,
	botaoSair;
	public JTextField textTabela,
	textSql;
	public JTextArea areaResult;

	public Sanchris(){

		this.frame = new JFrame("Sanchris");
		this.frame.setLayout(new BorderLayout());
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(650,500);
		this.frame.setVisible(true);

		this.labelBemVindo = new JLabel("Bem Vindo ao Sanchris - Testes Transacoes BD");

		this.botaoInsert    = new JButton("Insert");
		this.botaoDelete    = new JButton("Delete");
		this.botaoUpdate    = new JButton("Update");
		this.botaoExecutar  = new JButton("Executar Query");
		this.botaoBegin     = new JButton("Begin");
		this.botaoCommit    = new JButton("Commit");
		this.botaoRollback  = new JButton("Rollback");
		this.botaoSair 		= new JButton("Sair");

		this.botaoInsert.addActionListener(this);
		this.botaoDelete.addActionListener(this);
		this.botaoUpdate.addActionListener(this);
		this.botaoExecutar.addActionListener(this);
		this.botaoBegin.addActionListener(this);
		this.botaoCommit.addActionListener(this);
		this.botaoRollback.addActionListener(this);
		this.botaoSair.addActionListener(this);

		this.labelTabela = new JLabel("  Informe a Tabela  ");
		this.labelVazia = new JLabel("  ");
		this.textTabela  = new JTextField(" ", 15);

		this.panelWest = new JPanel();
		this.panelWest.setLayout(new GridLayout(10, 1, 75, 8));

		this.panelWest.add(this.botaoInsert);
		this.panelWest.add(this.botaoUpdate);
		this.panelWest.add(this.botaoDelete);
		this.panelWest.add(this.labelTabela);
		this.panelWest.add(this.textTabela);
		this.panelWest.add(this.botaoExecutar);
		this.panelWest.add(this.botaoBegin);
		this.panelWest.add(this.botaoCommit);
		this.panelWest.add(this.botaoRollback);
		this.panelWest.add(this.botaoSair);

		this.panelCenter = new JPanel();
		this.textSql   	 = new JTextField("Informe a sql", 40);
		this.areaResult  = new JTextArea("Aqui aparecera o resultado do banco", 23, 40);

		this.panelCenter.add(this.textSql);
		this.panelCenter.add(this.areaResult);

		this.frame.add(BorderLayout.NORTH,this.labelBemVindo);
		this.frame.add(BorderLayout.WEST,this.panelWest);
		this.frame.add(BorderLayout.CENTER,this.panelCenter);
		this.frame.setVisible(true);
	}

	public static void main(String args[]){
		new Sanchris();
	}

	public void actionPerformed(ActionEvent e){

		this.panelCenter = new JPanel();
		this.panelCenter = new JPanel();


		if(e.getSource() == botaoInsert){

			this.montaAtribuiSql("insert");

		} else if(e.getSource() == botaoUpdate) {

			this.montaAtribuiSql("update");

		} else if(e.getSource() == botaoDelete) {
			
			this.montaAtribuiSql("delete");

		} else if(e.getSource() == botaoExecutar) {

			this.executeSql();

		} else if(e.getSource() == botaoSair) {

			this.frame.dispose();

		} else {
			JOptionPane.showMessageDialog(null, "Comando invalido!");
		}
	}

	public void montaAtribuiSql(String metodo){

		String sql;
		String tabela;

		tabela = this.textTabela.getText();

		if(metodo == "insert"){

			sql = "INSERT INTO " + tabela + " (coluna) VALUES (valor)";

		} else if(metodo == "update"){

			sql = "UPDATE " + tabela + " SET coluna = valor WHERE condicao";

		} else {

			sql = "DELETE FROM " + tabela + " WHERE condicao";

		}

		this.textSql.setText(sql);
		JOptionPane.showMessageDialog(null, "Complete o sql e entao execute!");
	}


	public void executeSql(){

		String sql = this.textSql.getText();
		String result = " ";

		Conexao conexao = new Conexao();
		Connection conn = conexao.getConnect();

		if (conn != null){
			Statement statement = null;

			try{
				statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);

				while(resultSet.next())
					result += resultSet.getString("current_user");

				this.areaResult.setText(result);

			}catch(Exception e){

				JOptionPane.showMessageDialog(null, "Houve um erro na conexão!");

			}
		}
	}

}
