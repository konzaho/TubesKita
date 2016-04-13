/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Fiqih
 */
import View.MainFrame;
import View.LoginPanel;
import View.AccountPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.*;
        
public class LoginPanelController extends MouseAdapter implements ActionListener {
    
    private LoginPanel lp = new LoginPanel();
    private MainFrame mf = new MainFrame();
    private AccountPanel ap = new AccountPanel();
    
    public LoginPanelController(){
        showLoginPanel();
    }
    
    public void showLoginPanel(){
        mf.setLayout(new BorderLayout());
        mf.add(lp, BorderLayout.CENTER);
        mf.setVisible(true);
        lp.getCreateAkunButton().addActionListener(this);
        lp.getLoginButton().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == lp.getCreateAkunButton()){
            lp.setVisible(false);
            mf.setLayout(new BorderLayout());
            mf.add(ap, BorderLayout.CENTER);
            mf.setVisible(true);
            System.out.println("Konzaho");
        }
    }
    
}
