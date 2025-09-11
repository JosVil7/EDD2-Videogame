package com.mycompany.allaybotai.view;

import com.mycompany.allaybotai.controller.GameController;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
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

        Mapa = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        panelReturn = new javax.swing.JPanel();
        labelRegresar = new javax.swing.JLabel();
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
        panelInventory = new javax.swing.JPanel();
        labelInventory = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Guardians Of The Ancient Forest");
        setMinimumSize(new java.awt.Dimension(700, 600));
        setSize(new java.awt.Dimension(0, 0));

        Mapa.setBackground(new java.awt.Color(46, 125, 50));
        Mapa.setMaximumSize(new java.awt.Dimension(400, 400));
        Mapa.setMinimumSize(new java.awt.Dimension(250, 250));
        Mapa.setPreferredSize(new java.awt.Dimension(400, 400));
        Mapa.setLayout(new java.awt.GridLayout(5, 5));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel3.setText("Guardians of The Ancient Forest");

        panelReturn.setBackground(new java.awt.Color(45, 45, 45));
        panelReturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelReturnMouseClicked(evt);
            }
        });

        labelRegresar.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelRegresar.setText("Return");

        javax.swing.GroupLayout panelReturnLayout = new javax.swing.GroupLayout(panelReturn);
        panelReturn.setLayout(panelReturnLayout);
        panelReturnLayout.setHorizontalGroup(
            panelReturnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReturnLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(labelRegresar)
                .addGap(24, 24, 24))
        );
        panelReturnLayout.setVerticalGroup(
            panelReturnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReturnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelRegresar)
                .addContainerGap())
        );

        eventPanel.setBackground(new java.awt.Color(51, 51, 51));
        eventPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        eventPanel.setMaximumSize(new java.awt.Dimension(250, 200));
        eventPanel.setMinimumSize(new java.awt.Dimension(200, 200));
        eventPanel.setPreferredSize(new java.awt.Dimension(200, 200));
        eventPanel.setLayout(new javax.swing.BoxLayout(eventPanel, javax.swing.BoxLayout.Y_AXIS));

        eventIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eventIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/characterPortrait.gif"))); // NOI18N
        eventIcon.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        eventIcon.setIconTextGap(0);
        eventIcon.setName(""); // NOI18N
        eventPanel.add(eventIcon);

        labelSpeech.setText("if you can read this you're cooked");
        labelSpeech.setFocusable(false);
        labelSpeech.setMaximumSize(new java.awt.Dimension(200, 100));
        labelSpeech.setPreferredSize(new java.awt.Dimension(200, 100));
        labelSpeech.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        eventPanel.add(labelSpeech);

        panelOptions.setBackground(new java.awt.Color(51, 51, 51));
        panelOptions.setMinimumSize(new java.awt.Dimension(0, 110));
        panelOptions.setPreferredSize(new java.awt.Dimension(200, 100));

        panelButtonNo.setBackground(new java.awt.Color(51, 51, 51));
        panelButtonNo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelButtonNo.setMinimumSize(new java.awt.Dimension(90, 75));
        panelButtonNo.setPreferredSize(new java.awt.Dimension(90, 75));
        panelButtonNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelButtonNoMouseClicked(evt);
            }
        });
        panelButtonNo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelLessValue.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        labelLessValue.setText("No");
        panelButtonNo.add(labelLessValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        panelOptions.add(panelButtonNo);

        panelButtonYes.setBackground(new java.awt.Color(51, 51, 51));
        panelButtonYes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelButtonYes.setMinimumSize(new java.awt.Dimension(90, 75));
        panelButtonYes.setPreferredSize(new java.awt.Dimension(90, 75));
        panelButtonYes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelButtonYesMouseClicked(evt);
            }
        });
        panelButtonYes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelHigherValue.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        labelHigherValue.setText("Yes");
        panelButtonYes.add(labelHigherValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        panelOptions.add(panelButtonYes);

        eventPanel.add(panelOptions);

        panelContinue.setBackground(new java.awt.Color(51, 51, 51));
        panelContinue.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelContinue.setPreferredSize(new java.awt.Dimension(200, 137));
        panelContinue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelContinueMouseClicked(evt);
            }
        });
        panelContinue.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelContinue.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        labelContinue.setText("Continue");
        panelContinue.add(labelContinue, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        eventPanel.add(panelContinue);

        panelInventory.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelInventory.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        labelInventory.setText("Inventory");
        panelInventory.add(labelInventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        outputTextArea.setEditable(false);
        outputTextArea.setColumns(20);
        outputTextArea.setRows(5);
        outputTextArea.setFocusable(false);
        jScrollPane1.setViewportView(outputTextArea);

        panelInventory.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 150, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelInventory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eventPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Mapa, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Mapa, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                        .addComponent(eventPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelInventory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

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
            this.controller.goPortal(true);
        }
    }//GEN-LAST:event_panelButtonNoMouseClicked

    private void panelButtonYesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelButtonYesMouseClicked
              if (chest) {
            this.controller.openChest(true);
        } else {
            this.controller.goPortal(true);
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
