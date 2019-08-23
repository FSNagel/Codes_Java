import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class Sanchris implements ActionListener{

  public JFrame frame;
	public JButton botao;
	public JPanel panelWest;
	public JPanel panelCenter;
	public JPanel panelList;
	public JLabel textoBemVindo;
	public JButton botaoInsert,
  botaoDelete,
  botaoUpdate,
  botaoBegin,
  botaoCommit,
  botaoRollback,
  botaoSair;

  public Sanchris(){
        this.frame = new JFrame("Sanchris");
    		this.frame.setLayout(new BorderLayout());
    		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		this.frame.setSize(750,525);
    		this.frame.setVisible(true);

    		this.textoBemVindo = new JLabel("<html><h1>Bem Vindo ao Sanchris - Testes Transações BD</h1></html>");

    		this.botaoInsert    = new JButton("Insert");
    		this.botaoDelete    = new JButton("Delete");
    		this.botaoUpdate    = new JButton("Update");
    		this.botaoBegin     = new JButton("Begin");
    		this.botaoCommit    = new JButton("Commit");
    		this.botaoRollback  = new JButton("Rollback");
    		this.botaoSair 		  = new JButton("Sair");

    		this.botaoInsert.addActionListener(this);
    		this.botaoDelete.addActionListener(this);
    		this.botaoUpdate.addActionListener(this);
    		this.botaoBegin.addActionListener(this);
    		this.botaoCommit.addActionListener(this);
    		this.botaoRollback.addActionListener(this);
    		this.botaoSair.addActionListener(this);

    		this.panelWest = new JPanel();
    		this.panelWest.setLayout(new GridLayout(7, 1));

    		this.panelWest.add(this.botaoInsert);
    		this.panelWest.add(this.botaoDelete);
    		this.panelWest.add(this.botaoUpdate);
    		this.panelWest.add(this.botaoBegin);
    		this.panelWest.add(this.botaoCommit);
    		this.panelWest.add(this.botaoRollback);
    		this.panelWest.add(this.botaoSair);

    		this.frame.add(BorderLayout.NORTH,this.textoBemVindo);
    		this.frame.add(BorderLayout.WEST,this.panelWest);
    		this.frame.setVisible(true);
  }
  public static void main(String args[]){
    new Sanchris();
  }
}
