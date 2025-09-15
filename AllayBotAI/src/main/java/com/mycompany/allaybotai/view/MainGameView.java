package com.mycompany.allaybotai.view;

import com.mycompany.allaybotai.controller.GameController;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainGameView extends javax.swing.JFrame {

    private final GameController controller;
    public int turnosRestantes = 25;
    private boolean chest = true;

    public MainGameView(GameController controller) throws IOException {
        this.controller = controller;
        initComponents();
        this.showEventNothing();
        this.eventIcon.setIcon(new ImageIcon(getClass().getResource("/images/characterPortrait.gif")));
        setIconImage(new ImageIcon(getClass().getResource("/images/tiles/front.png")).getImage());
    }

    public JPanel getMapa() {
        return Mapa;
    }

    public void createTiles() throws IOException {
        for (int i = 0; i < 25; i++) {
            JLabel tile = new JLabel();
            Image img = ImageIO.read(getClass().getResource("/images/tiles/unexplored.png"));
            img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            tile.setIcon(new ImageIcon(img));
            tile.setBorder(null);
            Mapa.add(tile);
        }

    }

    private void endGame() {
        deshabilitarComponentes(0);
    }

    // Metodo recursivo para los componentes
    private void deshabilitarComponentes(int index) {
        if (index >= Mapa.getComponentCount()) {
            return; // Caso base cuando ya se recorrieron todos los componentes
        }
        Mapa.getComponent(index).setEnabled(false);
        deshabilitarComponentes(index + 1); // Llamada recursiva
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        panelReturn = new javax.swing.JPanel();
        labelRegresar = new javax.swing.JLabel();
        Mapa = new javax.swing.JPanel();
        panelInventory = new javax.swing.JPanel();
        labelInventory = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextArea();
        eventPanel = new javax.swing.JPanel();
        eventIcon = new javax.swing.JLabel();
        labelSpeech = new javax.swing.JLabel();
        panelOptions = new javax.swing.JPanel();
        panelButtonNo = new javax.swing.JPanel();
        labelLessValue = new javax.swing.JLabel();
        panelButtonYes = new javax.swing.JPanel();
        labelHigherValue = new javax.swing.JLabel();
        panelContinue = new javax.swing.JPanel();
        labelContinue = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Guardians Of The Ancient Forest");
        setMinimumSize(new java.awt.Dimension(700, 600));
        setSize(new java.awt.Dimension(0, 0));

        mainPanel.setBackground(new java.awt.Color(26, 92, 74));
        mainPanel.setMinimumSize(new java.awt.Dimension(700, 600));

        jLabel3.setFont(new java.awt.Font("SansSerif", 3, 36)); // NOI18N
        jLabel3.setText("Guardians of The Ancient Forest");

        panelReturn.setBackground(new java.awt.Color(5, 51, 36));
        panelReturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelReturnMouseClicked(evt);
            }
        });

        labelRegresar.setFont(new java.awt.Font("sansserif", 3, 18)); // NOI18N
        labelRegresar.setText("Return");

        javax.swing.GroupLayout panelReturnLayout = new javax.swing.GroupLayout(panelReturn);
        panelReturn.setLayout(panelReturnLayout);
        panelReturnLayout.setHorizontalGroup(
            panelReturnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReturnLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(labelRegresar)
                .addGap(22, 22, 22))
        );
        panelReturnLayout.setVerticalGroup(
            panelReturnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReturnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelRegresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Mapa.setBackground(new java.awt.Color(46, 125, 50));
        Mapa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 28, 19), 10, true));
        Mapa.setMinimumSize(new java.awt.Dimension(250, 250));
        Mapa.setLayout(new java.awt.GridLayout(5, 5));

        panelInventory.setBackground(new java.awt.Color(5, 51, 36));
        panelInventory.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 28, 19), 5, true));
        panelInventory.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelInventory.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        labelInventory.setText("Inventory");
        panelInventory.add(labelInventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        outputTextArea.setEditable(false);
        outputTextArea.setBackground(new java.awt.Color(1, 28, 19));
        outputTextArea.setColumns(1);
        outputTextArea.setRows(5);
        outputTextArea.setFocusable(false);
        jScrollPane1.setViewportView(outputTextArea);

        panelInventory.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 150, 460));

        eventPanel.setBackground(new java.awt.Color(5, 51, 36));
        eventPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        eventPanel.setMinimumSize(new java.awt.Dimension(200, 200));
        eventPanel.setPreferredSize(new java.awt.Dimension(200, 200));
        eventPanel.setLayout(new javax.swing.BoxLayout(eventPanel, javax.swing.BoxLayout.Y_AXIS));

        eventIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eventIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/characterPortrait.gif"))); // NOI18N
        eventIcon.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        eventIcon.setIconTextGap(0);
        eventIcon.setName(""); // NOI18N
        eventPanel.add(eventIcon);

        labelSpeech.setFont(new java.awt.Font("SansSerif", 3, 14)); // NOI18N
        labelSpeech.setText("if you can read this you're cooked");
        labelSpeech.setFocusable(false);
        labelSpeech.setMaximumSize(new java.awt.Dimension(200, 100));
        labelSpeech.setPreferredSize(new java.awt.Dimension(200, 100));
        labelSpeech.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        eventPanel.add(labelSpeech);

        panelOptions.setBackground(new java.awt.Color(5, 51, 36));
        panelOptions.setMinimumSize(new java.awt.Dimension(0, 110));
        panelOptions.setPreferredSize(new java.awt.Dimension(200, 100));

        panelButtonNo.setBackground(new java.awt.Color(1, 28, 19));
        panelButtonNo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelButtonNo.setMinimumSize(new java.awt.Dimension(90, 75));
        panelButtonNo.setPreferredSize(new java.awt.Dimension(90, 75));
        panelButtonNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelButtonNoMouseClicked(evt);
            }
        });
        panelButtonNo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelLessValue.setFont(new java.awt.Font("SansSerif", 3, 24)); // NOI18N
        labelLessValue.setText("No");
        panelButtonNo.add(labelLessValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        panelOptions.add(panelButtonNo);

        panelButtonYes.setBackground(new java.awt.Color(1, 28, 19));
        panelButtonYes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelButtonYes.setMinimumSize(new java.awt.Dimension(90, 75));
        panelButtonYes.setPreferredSize(new java.awt.Dimension(90, 75));
        panelButtonYes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelButtonYesMouseClicked(evt);
            }
        });
        panelButtonYes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelHigherValue.setFont(new java.awt.Font("SansSerif", 3, 24)); // NOI18N
        labelHigherValue.setText("Yes");
        panelButtonYes.add(labelHigherValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        panelOptions.add(panelButtonYes);

        eventPanel.add(panelOptions);

        panelContinue.setBackground(new java.awt.Color(1, 28, 19));
        panelContinue.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelContinue.setPreferredSize(new java.awt.Dimension(200, 137));
        panelContinue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelContinueMouseClicked(evt);
            }
        });
        panelContinue.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelContinue.setFont(new java.awt.Font("SansSerif", 3, 24)); // NOI18N
        labelContinue.setText("Continue");
        panelContinue.add(labelContinue, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        eventPanel.add(panelContinue);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addComponent(panelReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(eventPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(panelReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Mapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelInventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eventPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void panelReturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelReturnMouseClicked
        controller.goToStartMenu(this);
    }//GEN-LAST:event_panelReturnMouseClicked

    private void panelContinueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelContinueMouseClicked
        this.showEventNothing();
        this.controller.setMovementEnabled(true);
    }//GEN-LAST:event_panelContinueMouseClicked

    private void panelButtonNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelButtonNoMouseClicked
        if (chest) {
            this.controller.openChest(false);
        } else {
            try {
                this.controller.goPortal(false);
            } catch (IOException ex) {
                Logger.getLogger(MainGameView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_panelButtonNoMouseClicked

    private void panelButtonYesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelButtonYesMouseClicked
        if (chest) {
            this.controller.openChest(true);
        } else {
            try {
                this.controller.goPortal(true);
            } catch (IOException ex) {
                Logger.getLogger(MainGameView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_panelButtonYesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Mapa;
    private javax.swing.JLabel eventIcon;
    private javax.swing.JPanel eventPanel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelContinue;
    private javax.swing.JLabel labelHigherValue;
    private javax.swing.JLabel labelInventory;
    private javax.swing.JLabel labelLessValue;
    private javax.swing.JLabel labelRegresar;
    private javax.swing.JLabel labelSpeech;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextArea outputTextArea;
    private javax.swing.JPanel panelButtonNo;
    private javax.swing.JPanel panelButtonYes;
    private javax.swing.JPanel panelContinue;
    private javax.swing.JPanel panelInventory;
    private javax.swing.JPanel panelOptions;
    private javax.swing.JPanel panelReturn;
    // End of variables declaration//GEN-END:variables

    public void setPlayerFront(int playerPosition) throws IOException {
        JLabel tile = (JLabel) this.Mapa.getComponent(playerPosition);
        Image img = ImageIO.read(getClass().getResource("/images/tiles/front.png"));
        img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        tile.setIcon(new ImageIcon(img));
    }

    public void setPlayerBack(int playerPosition) throws IOException {
        JLabel tile = (JLabel) this.Mapa.getComponent(playerPosition);
        Image img = ImageIO.read(getClass().getResource("/images/tiles/back.png"));
        img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        tile.setIcon(new ImageIcon(img));
    }

    public void setPlayerLeft(int playerPosition) throws IOException {
        JLabel tile = (JLabel) this.Mapa.getComponent(playerPosition);
        Image img = ImageIO.read(getClass().getResource("/images/tiles/left.png"));
        img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        tile.setIcon(new ImageIcon(img));
    }

    public void setPlayerRight(int playerPosition) throws IOException {
        JLabel tile = (JLabel) this.Mapa.getComponent(playerPosition);
        Image img = ImageIO.read(getClass().getResource("/images/tiles/right.png"));
        img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        tile.setIcon(new ImageIcon(img));
    }

    public void setTileChest(int playerPosition) throws IOException {
        JLabel tile = (JLabel) this.Mapa.getComponent(playerPosition);
        Image img = ImageIO.read(getClass().getResource("/images/tiles/chest.png"));
        img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        tile.setIcon(new ImageIcon(img));
    }

    public void setTileEmpty(int playerPosition) throws IOException {
        JLabel tile = (JLabel) this.Mapa.getComponent(playerPosition);
        Image img = ImageIO.read(getClass().getResource("/images/tiles/empty.png"));
        img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        tile.setIcon(new ImageIcon(img));
    }

    public void setTileBoss(int playerPosition) throws IOException {
        JLabel tile = (JLabel) this.Mapa.getComponent(playerPosition);
        Image img = ImageIO.read(getClass().getResource("/images/tiles/boss.png"));
        img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        tile.setIcon(new ImageIcon(img));
    }

    public void setTilePortal(int playerPosition) throws IOException {
        JLabel tile = (JLabel) this.Mapa.getComponent(playerPosition);
        Image img = ImageIO.read(getClass().getResource("/images/tiles/portal.png"));
        img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        tile.setIcon(new ImageIcon(img));
    }

    public void setTileTrap(int playerPosition) throws IOException {
        JLabel tile = (JLabel) this.Mapa.getComponent(playerPosition);
        Image img = ImageIO.read(getClass().getResource("/images/tiles/trap.png"));
        img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        tile.setIcon(new ImageIcon(img));
    }

    public void setTileLocked(int playerPosition) throws IOException {
        JLabel tile = (JLabel) this.Mapa.getComponent(playerPosition);
        Image img = ImageIO.read(getClass().getResource("/images/tiles/locked.png"));
        img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        tile.setIcon(new ImageIcon(img));
    }

    private void showEventNothing() {
        this.labelSpeech.setText("<html><p>>Use WASD or</p>\n"
                + "<p>the arrows to move.&nbsp;</p></html>");
        this.panelButtonNo.setVisible(false);
        this.panelButtonYes.setVisible(false);
        this.eventIcon.setIcon(new ImageIcon(getClass().getResource("/images/characterPortrait.gif")));
        this.panelContinue.setVisible(false);

    }

    //Ask to open chest or not
    public void showEventLockedChest(String message) {
        this.labelSpeech.setText(message);
        this.panelButtonNo.setVisible(true);
        this.panelButtonYes.setVisible(true);
        this.panelContinue.setVisible(false);
        this.controller.setMovementEnabled(false);
        this.chest = true;
    }

    //Ask to go in portal or not
    public void showEventPortal(String message) {
        this.labelSpeech.setText(message);
        this.panelButtonNo.setVisible(true);
        this.panelButtonYes.setVisible(true);
        this.panelContinue.setVisible(false);
        this.controller.setMovementEnabled(false);
        this.chest = false;
    }

    //Show a message
    public void showEventResponse(String message) {
        this.labelSpeech.setText(message);
        this.panelButtonNo.setVisible(false);
        this.panelButtonYes.setVisible(false);
        this.panelContinue.setVisible(true);
        this.eventIcon.setIcon(new ImageIcon(getClass().getResource("/images/happyPortrait.gif")));
        this.controller.setMovementEnabled(false);
    }

    //Trap
    public void showEventTrap(String message) {
        this.labelSpeech.setText(message);
        this.panelButtonNo.setVisible(false);
        this.panelButtonYes.setVisible(false);
        this.panelContinue.setVisible(true);
        this.eventIcon.setIcon(new ImageIcon(getClass().getResource("/images/trapPortrait.gif")));
        this.controller.setMovementEnabled(false);
    }

    //Boss
    public void showEventBoss(String message) {
        this.labelSpeech.setText(message);
        this.panelButtonNo.setVisible(false);
        this.panelButtonYes.setVisible(false);
        this.panelContinue.setVisible(true);
        this.eventIcon.setIcon(new ImageIcon(getClass().getResource("/images/scaredPortrait.gif")));
        this.controller.setMovementEnabled(false);
    }

    //No chest option 
    public void showEventNoChest(String message) {
        this.labelSpeech.setText(message);
        this.panelButtonNo.setVisible(false);
        this.panelButtonYes.setVisible(false);
        this.panelContinue.setVisible(true);
        this.eventIcon.setIcon(new ImageIcon(getClass().getResource("/images/sadPortrait.gif")));
        this.controller.setMovementEnabled(false);
    }

    //We've already been here
    public void showEventTileAlreadyExplored(String message) {
        this.labelSpeech.setText(message);
        this.panelButtonNo.setVisible(false);
        this.panelButtonYes.setVisible(false);
        this.panelContinue.setVisible(false);
        this.controller.setMovementEnabled(true);
    }

    //Update inventory method
    public void updateInventory(ArrayList<String> list) {
        this.outputTextArea.setText("");
        for (String gemName : list) {
            outputTextArea.append(gemName + "\n");
        }
    }
}
