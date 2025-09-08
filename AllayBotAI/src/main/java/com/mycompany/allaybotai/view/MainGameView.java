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

//    private void explorarCelda(int fila, int columna) {
//        jugadorFila = fila;
//        jugadorColumna = columna;
//
//        // Actualizar la etiqueta con el número de la celda
//        Posicion.setText("Celda: " + (fila * gridSize + columna + 1));
//
//        if (turnosRestantes <= 0) {
//            JOptionPane.showMessageDialog(null, "¡No tienes más turnos! Fin del juego.");
//            finalizarJuego();
//            return;
//        }
//
//        int celdaActual = mapa[fila][columna]; // Valor de la celda en el mapa
//
//        if (celdaActual == 1) { // Tesoro encontrado
//            int decrementoms = 1;//para usar en la funcion recursiva
//
//            tesorosEncontrados = tesorosmas(tesorosEncontrados, decrementoms);//recursividad
//            mapa[fila][columna] = 0; // Eliminar el tesoro del mapa
//            JOptionPane.showMessageDialog(null, "¡Encontraste un tesoro!");
//            Tesoros.setText("Tesoros encontrados: " + tesorosEncontrados);
//            turnosRestantes = trampa(turnosRestantes, decrementoms);
//            Turnos.setText("Turnos restantes: " + turnosRestantes);
//
//        } else if (celdaActual == -1) { // Trampa encontrada
//            int decrementot = 2;// Decrementos para la funciones recursivas de los reductores de los turnos en las trampas
//            int decrementom = 1;// Decrementoss para la funcion recursiva de los reductores de tesoros en la trampas
//
//            JOptionPane.showMessageDialog(null, "¡Pisas una trampa! Pierdes un turno");
//            turnosRestantes = trampa(turnosRestantes, decrementot);
//            Turnos.setText("Turnos restantes: " + turnosRestantes);
//
//            if (tesorosEncontrados > 0) {
//                JOptionPane.showMessageDialog(null, "Pierdes un tesoro."); //para decontar los tesoros aparte
//                tesorosEncontrados = tesorosmenos(tesorosEncontrados, decrementom);
//                Tesoros.setText("Tesoros encontrados: " + tesorosEncontrados);
//            }
//
//            if (turnosRestantes <= 0) {
//                JOptionPane.showMessageDialog(null, "¡No tienes más turnos! Fin del juego.");
//                finalizarJuego();
//                return;
//            }
//
//        } else { // Celda vacía
//            int decrementosv = 1;
//            JOptionPane.showMessageDialog(null, "Nada en esta celda.");
//            turnosRestantes = trampa(turnosRestantes, decrementosv);//recursividad
//            Turnos.setText("Turnos restantes: " + turnosRestantes);
//        }
//
//        // Verificar si se han encontrado todos los tesoros
//        if (tesorosEncontrados == 5) {
//            JOptionPane.showMessageDialog(null, "¡Has encontrado todos los tesoros! ¡Ganaste!");
//            finalizarJuego();
//        }
//    }
    //Funcion recursiva para ir quitando turnos extra cuando caes en una trampa
    private static int trampa(int turnosRestantes, int decremento) {
        if (decremento <= 0) {
            return turnosRestantes;
        }
        return trampa(turnosRestantes - 1, decremento - 1);
    }

    //Funcion recursiva para ir quitando los tesoros cuando caes en una trampa
    private static int tesorosmenos(int tesorosEncontrados, int decrementosm) {
        if (decrementosm <= 0) {
            return tesorosEncontrados;
        }
        return tesorosmenos(tesorosEncontrados - 1, decrementosm - 1);
    }

    //Funcion recursiva para ir dando los tesoros cuando lso encuentras
    private static int tesorosmas(int tesorosEncontrados, int decrementosms) {
        if (decrementosms <= 0) {
            return tesorosEncontrados;
        }
        return tesorosmenos(tesorosEncontrados + 1, decrementosms - 1);
    }

    private void finalizarJuego() {
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
                                .addComponent(Posicion, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(143, 143, 143)
                        .addComponent(Turnos, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Tesoros, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Regresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(354, 354, 354)
                        .addComponent(Mapa, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)))
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
                .addComponent(Mapa, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
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
