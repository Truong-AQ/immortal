/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl;

import static btl.DictionaryApplication.t;
import static btl.DictionaryApplication.t1;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.DefaultListModel;
import java.awt.Color;
import javax.swing.JOptionPane;
/**
 *
 * @author Genius
 */
public class DictionaryApplication {
    static DictionaryCommandLine t = new DictionaryCommandLine();
    static Dictionary t1 = t.getTd();
    public void runApplication(){
        new frameMain().setVisible(true);
    }
}
class delete extends javax.swing.JFrame {
    public delete() {
        initComponents();
        this.setResizable(false);
        this.setLocation(120, 130);
        this.getContentPane().setBackground(Color.CYAN);
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        delete = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        fillWord = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Delete");

        delete.setText("Xóa");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        exit.setText("Thoát");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        jLabel1.setText("Từ muôn xóa:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(exit)
                .addGap(69, 69, 69))
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fillWord, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fillWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete)
                    .addComponent(exit))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>                        

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        try {
            int vt = t.dictionaryLookup(fillWord.getText());
            if(vt != -1)
            if(t1.elementAt(vt).getWord_target().equals(fillWord.getText())){
                t1.remove(vt);
                JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
            }
            else
                JOptionPane.showMessageDialog(null, "Không có trong từ điển", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
        }
    }                                      

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        this.dispose();
    }
    private javax.swing.JButton delete;
    private javax.swing.JButton exit;
    private javax.swing.JTextField fillWord;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
}

class insert extends javax.swing.JFrame {

    public insert() {
        initComponents();
        this.setLocation(120, 130);
        this.getContentPane().setBackground(Color.CYAN);
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        fillWord = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        fillMean = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Insert");

        fillMean.setColumns(20);
        fillMean.setRows(5);
        jScrollPane1.setViewportView(fillMean);

        jLabel1.setText("Từ muốn thêm: ");

        jLabel2.setText("Nghĩa:");

        save.setText("Thêm");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        exit.setText("Thoát");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fillWord, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exit)
                .addGap(97, 97, 97))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fillWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(exit))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>                        

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        Word w = new Word(fillWord.getText(), fillMean.getText());
        int vt = t.dictionaryLookup(w.getWord_target());
        if(vt == -1){
            t1.add(0, w);
            JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
        }
        else if(vt != -1)
        if(!t1.elementAt(vt).getWord_target().equals(w.getWord_target())){
            t1.add(vt + 1, w);
            JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
        }
        else
            JOptionPane.showMessageDialog(null, "Đã có trong từ điển", "Thông báo", JOptionPane.ERROR_MESSAGE);
    }                                    

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        this.dispose();
    }                                    
    private javax.swing.JButton exit;
    private javax.swing.JTextArea fillMean;
    private javax.swing.JTextField fillWord;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton save;
    // End of variables declaration                   
}

class edit extends javax.swing.JFrame {

    public edit() {
        initComponents();
        this.setResizable(false);
        this.setLocation(120, 130);
        this.getContentPane().setBackground(Color.CYAN);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        word1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        word2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        meanWord2 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        edit = new javax.swing.JButton();
        exit = new javax.swing.JButton();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit");

        jLabel1.setText("Từ cần sửa:");

        jLabel2.setText("Sửa thành từ: ");

        meanWord2.setColumns(20);
        meanWord2.setRows(5);
        jScrollPane1.setViewportView(meanWord2);

        jLabel3.setText("Nghĩa: ");

        edit.setText("Sửa");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        exit.setText("Thoát");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(word1)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(word2)
                            .addComponent(edit)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(exit)
                                .addGap(16, 16, 16)))))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(word1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(word2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edit)
                    .addComponent(exit))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>                        

    private void editActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        int vt = t.dictionaryLookup(word1.getText());
        if(vt != -1){
            if(t1.elementAt(vt).getWord_target().equals(word1.getText())){
                t1.remove(vt);
                int vt1 = t.dictionaryLookup(word2.getText());
                if(vt1 == -1){
                    t1.add(0, new Word(word2.getText(), meanWord2.getText()));
                }
                else{
                    if(t1.elementAt(vt).getWord_target().equals(word2.getText()))
                        t1.elementAt(vt).setWord_explain(meanWord2.getText());
                    else
                        t1.add(vt1 + 1, new Word(word2.getText(), meanWord2.getText()));
                }
                JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
            }
            else
                JOptionPane.showMessageDialog(null, "Từ cần sửa không có trong từ điển", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        else
        JOptionPane.showMessageDialog(null, "Từ cần sửa không có trong từ điển", "Thông báo", JOptionPane.ERROR_MESSAGE);
    }                                    

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        this.dispose();
    }

    private javax.swing.JButton edit;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextArea meanWord2;
    private javax.swing.JTextField word1;
    private javax.swing.JTextField word2;
    // End of variables declaration                   
}



class frameMain extends javax.swing.JFrame {
    public frameMain() {
        initComponents();
        this.getContentPane().setBackground(Color.yellow);
        this.setLocation(150, 150);
        this.setResizable(false);
        means.setWrapStyleWord(true);
        means.setLineWrap(true);
    }
    @SuppressWarnings("unchecked")                         
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        whereFillWord = new javax.swing.JTextField();
        translate = new javax.swing.JButton();
        pronounce = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        suggestions = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        means = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        delete = new javax.swing.JMenu();
        edit = new javax.swing.JMenu();
        insert = new javax.swing.JMenu();
        exit = new javax.swing.JMenu();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dictionary");

        whereFillWord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                whereFillWordKeyReleased(evt);
            }
        });

        translate.setBackground(new java.awt.Color(255, 51, 51));
        translate.setText("Dịch");
        translate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translateActionPerformed(evt);
            }
        });

        pronounce.setBackground(new java.awt.Color(51, 102, 255));
        pronounce.setText("Phát âm");
        pronounce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pronounceActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        jLabel1.setText("NGHĨA");

        jLabel2.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N
        jLabel2.setText("IMMORTAL");

        suggestions.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                suggestionsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(suggestions);

        means.setColumns(20);
        means.setRows(5);
        jScrollPane2.setViewportView(means);

        delete.setText("Xóa");
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        jMenuBar1.add(delete);

        edit.setText("Sửa");
        edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editMouseClicked(evt);
            }
        });
        jMenuBar1.add(edit);

        insert.setText("Thêm");
        insert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertMouseClicked(evt);
            }
        });
        jMenuBar1.add(insert);

        exit.setText("Thoát");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        jMenuBar1.add(exit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(75, 75, 75))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(whereFillWord, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(translate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pronounce)
                        .addContainerGap(216, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(translate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pronounce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(whereFillWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)))
        );

        pack();
    }// </editor-fold>                        

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {                                    
        // TODO add your handling code here
        new delete().setVisible(true);
    }                                   

    private void editMouseClicked(java.awt.event.MouseEvent evt) {                                  
        // TODO add your handling code here:
       new edit().setVisible(true);
    }                                 

    private void insertMouseClicked(java.awt.event.MouseEvent evt) {                                    
        // TODO add your handling code here:
        new insert().setVisible(true);
    }                                   

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {                                  
        // TODO add your handling code here:
        System.exit(0);
    }                                 

    @SuppressWarnings("unchecked")
    private void whereFillWordKeyReleased(java.awt.event.KeyEvent evt) {                                          
        // TODO add your handling code here:
        DefaultListModel model = new DefaultListModel();
            t.dictionarySeacher(model, whereFillWord.getText());
            suggestions.setModel(model);
    }                                         

    private void suggestionsValueChanged(javax.swing.event.ListSelectionEvent evt) {                                         
        // TODO add your handling code here:
        try {
            whereFillWord.setText(suggestions.getSelectedValue().toString());
        } catch (Exception e) {
            
        }
    }                                        

    private void pronounceActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        try(PrintWriter pw = new PrintWriter("C:\\Users\\Genius\\Documents\\sound.vbs")) {
            pw.print("CreateObject(" + '"' + "SAPI.SpVoice" + '"' + ").Speak" + '"' + whereFillWord.getText() + '"');
        } catch (Exception e) {
        }
        try {
            Runtime.getRuntime().exec( "wscript C:\\Users\\Genius\\Documents\\sound.vbs" );
        }
        catch( IOException e ) {
        }
    }                                         

    private void translateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        try {
            int vt = t.dictionaryLookup(whereFillWord.getText());
            if(t1.elementAt(vt).getWord_target().equals(whereFillWord.getText()))
                means.setText(t1.elementAt(vt).getWord_explain());
            else
                means.setText("Không có trong từ điển");
        } catch (Exception e) {
        }
        suggestions.setModel(new DefaultListModel());
    }                                         

    private javax.swing.JMenu delete;
    private javax.swing.JMenu edit;
    private javax.swing.JMenu exit;
    private javax.swing.JMenu insert;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea means;
    private javax.swing.JButton pronounce;
    private javax.swing.JList<String> suggestions;
    private javax.swing.JButton translate;
    private javax.swing.JTextField whereFillWord;
    // End of variables declaration                   
}
