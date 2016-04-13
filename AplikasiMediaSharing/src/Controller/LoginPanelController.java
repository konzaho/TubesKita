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
    
    public LoginPanelController(){
        showLoginPanel();
    }
    
    public void showLoginPanel(){
        mf.setLayout(new BorderLayout());
        mf.add(lp, BorderLayout.CENTER);
        mf.setVisible(true);
        if(lp.loginListener(null))
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
