package com.mycompany.allaybotai.view;

import com.mycompany.allaybotai.controller.GameController;
import java.awt.Image;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainGameView extends javax.swing.JFrame {

    private final GameController controller;
    private int jugadorFila = 0;
    private int jugadorColumna = 0;
    public int turnosRestantes = 25;

    private int tesorosEncontrados = 0;
    private final Random random = new Random();

    public MainGameView(GameController controller) throws IOException {
        this.controller = controller;
        initComponents();
        this.eventIcon.setIcon(new ImageIcon(getClass().getResource("/images/characterPortrait.gif")));
        setIconImage(new ImageIcon(getClass().getResource("/images/tesoro1_icon.png")).getImage());
    }

    public JPanel getMapa() {
        return Mapa;
    }

    public void createButtons() throws IOException {
        for (int i = 0; i < 25; i++) {
            JLabel tile = new JLabel();
            Image img = ImageIO.read(getClass().getResource("/images/tiles/unexplored.png"));
            img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            tile.setIcon(new ImageIcon(img));
            tile.setBorder(null);
            Mapa.add(tile);
        }

    }

    private void setEventIcon(String name) throws IOException{
         Image img = ImageIO.read(getClass().getResource("/images/tiles/front.png"));
        img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
         this.eventIcon.setIcon(new ImageIcon(img));
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
        Tesoros = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Regresar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Posicion = new javax.swing.JLabel();
        Turnos = new javax.swing.JLabel();
        eventPanel = new javax.swing.JPanel();
        eventIcon = new javax.swing.JLabel();
        eventText = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AllayQuest");

        Mapa.setBackground(new java.awt.Color(46, 125, 50));
        Mapa.setMaximumSize(new java.awt.Dimension(250, 250));
        Mapa.setPreferredSize(new java.awt.Dimension(250, 250));
        Mapa.setLayout(new java.awt.GridLayout(5, 5));

        Tesoros.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        Tesoros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Tesoros.setText("Tesoros encontrados: 0");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel3.setText("Chronicles of Allay");

        Regresar.setBackground(new java.awt.Color(45, 45, 45));
        Regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegresarMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setText("Regresar");

        javax.swing.GroupLayout RegresarLayout = new javax.swing.GroupLayout(Regresar);
        Regresar.setLayout(RegresarLayout);
        RegresarLayout.setHorizontalGroup(
            RegresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegresarLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(24, 24, 24))
        );
        RegresarLayout.setVerticalGroup(
            RegresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegresarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        Posicion.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        Posicion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Posicion.setText("Celda: Ninguna");
        Posicion.setToolTipText("");

        Turnos.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        Turnos.setForeground(new java.awt.Color(255, 153, 51));
        Turnos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Turnos.setText("Turnos restantes: 25");
        Turnos.setToolTipText("");

        eventPanel.setBackground(new java.awt.Color(51, 51, 51));
        eventPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        eventPanel.setMaximumSize(new java.awt.Dimension(250, 200));
        eventPanel.setLayout(new java.awt.BorderLayout());

        eventIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eventIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/characterPortrait.gif"))); // NOI18N
        eventIcon.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        eventIcon.setIconTextGap(0);
        eventIcon.setMaximumSize(new java.awt.Dimension(200, 200));
        eventIcon.setMinimumSize(new java.awt.Dimension(200, 200));
        eventIcon.setName(""); // NOI18N
        eventIcon.setPreferredSize(new java.awt.Dimension(200, 200));
        eventPanel.add(eventIcon, java.awt.BorderLayout.NORTH);

        eventText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eventText.setText("jLabel1");
        eventPanel.add(eventText, java.awt.BorderLayout.CENTER);

        jButton1.setText("jButton1");
        eventPanel.add(jButton1, java.awt.BorderLayout.PAGE_END);

        jButton2.setText("jButton2");
        eventPanel.add(jButton2, java.awt.BorderLayout.LINE_END);

        jButton3.setText("jButton3");
        eventPanel.add(jButton3, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(235, 235, 235)
                                .addComponent(Posicion, javax.swing.GroupLayout.PREFERRED_SIZE, 54, Short.MAX_VALUE)
                                .addGap(143, 143, 143))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(Turnos, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Tesoros, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Regresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(eventPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Mapa, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tesoros, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Posicion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Turnos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Mapa, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(eventPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegresarMouseClicked
        controller.goToStartMenu(this);
    }//GEN-LAST:event_RegresarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Mapa;
    private javax.swing.JLabel Posicion;
    private javax.swing.JPanel Regresar;
    private javax.swing.JLabel Tesoros;
    private javax.swing.JLabel Turnos;
    private javax.swing.JLabel eventIcon;
    private javax.swing.JPanel eventPanel;
    private javax.swing.JLabel eventText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
        Image img = ImageIO.read(getClass().getResource("/images/tiles/unexplored.png"));
        img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        tile.setIcon(new ImageIcon(img));
    }

    public void setTilePortal(int playerPosition) throws IOException {
        JLabel tile = (JLabel) this.Mapa.getComponent(playerPosition);
        Image img = ImageIO.read(getClass().getResource("/images/tiles/unexplored.png"));
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

    public void showEventChest(String message){
        
    }
}
