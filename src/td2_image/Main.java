package td2_image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author hamster
 */
public class Main extends javax.swing.JFrame {

    //JLabel lbl = new JLabel();
    ImageIcon icon = null;
    BufferedImage img = null;
    ImageOperationsEnum imgOperations = ImageOperationsEnum.ECHELLE;
    ColorsEnum colorsEnum = null;
    BufferedImage scaledImage = null;
    String imgPath = null;
    Color defaultBackground = null;
    
    DisplayGradient gradient = null;
    Resizing resizing = new Resizing(this,scaledImage);
    Recadrage recadrage = new Recadrage(this,scaledImage);
    SeamCarving seam = new SeamCarving(this);
    
    private int width = 0;
    private int height = 0;
    private int precent = 50;
        
    public Main() {
        initComponents();
        //setExtendedState(MAXIMIZED_BOTH);
        jSliderResizer.setMajorTickSpacing(10);
        jSliderResizer.setPaintTicks(true);
        //this.getContentPane().add(lbl);
        //this.setLayout(null);
        //this.setLocationRelativeTo(null);
        defaultBackground = jMenuEchelle.getBackground();
        jMenuEchelle.setBackground(Color.red);
    }

    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      btnBlue = new javax.swing.JButton();
      btnRed = new javax.swing.JButton();
      btnGreen = new javax.swing.JButton();
      jSliderResizer = new javax.swing.JSlider();
      btnRefresh = new javax.swing.JButton();
      jPanel1 = new javax.swing.JPanel();
      lblImage = new javax.swing.JLabel();
      jMenuBar1 = new javax.swing.JMenuBar();
      jMenu1 = new javax.swing.JMenu();
      jMenuItem1 = new javax.swing.JMenuItem();
      jMenuClear = new javax.swing.JMenuItem();
      itemSave = new javax.swing.JMenuItem();
      jMenuExit = new javax.swing.JMenuItem();
      jMenu2 = new javax.swing.JMenu();
      jMenuEchelle = new javax.swing.JMenuItem();
      jMenuRecader = new javax.swing.JMenuItem();
      jMenuSeamCav = new javax.swing.JMenuItem();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      btnBlue.setText("Blue grad");
      btnBlue.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnBlueActionPerformed(evt);
         }
      });

      btnRed.setText("Red grad");
      btnRed.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRedActionPerformed(evt);
         }
      });

      btnGreen.setText("Green grad");
      btnGreen.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnGreenActionPerformed(evt);
         }
      });

      jSliderResizer.setBackground(new java.awt.Color(204, 204, 204));
      jSliderResizer.setOrientation(javax.swing.JSlider.VERTICAL);
      jSliderResizer.setPaintLabels(true);
      jSliderResizer.setPaintTicks(true);
      jSliderResizer.addChangeListener(new javax.swing.event.ChangeListener() {
         public void stateChanged(javax.swing.event.ChangeEvent evt) {
            jSliderResizerStateChanged(evt);
         }
      });

      btnRefresh.setText("Recover");
      btnRefresh.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRefreshActionPerformed(evt);
         }
      });

      jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

      lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      lblImage.setToolTipText("");

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
            .addContainerGap())
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
            .addContainerGap())
      );

      jMenu1.setText("File");

      jMenuItem1.setText("Load");
      jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem1ActionPerformed(evt);
         }
      });
      jMenu1.add(jMenuItem1);

      jMenuClear.setText("Clear");
      jMenuClear.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuClearActionPerformed(evt);
         }
      });
      jMenu1.add(jMenuClear);

      itemSave.setText("Save");
      itemSave.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            itemSaveActionPerformed(evt);
         }
      });
      jMenu1.add(itemSave);

      jMenuExit.setText("Exit");
      jMenuExit.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuExitActionPerformed(evt);
         }
      });
      jMenu1.add(jMenuExit);

      jMenuBar1.add(jMenu1);

      jMenu2.setText("Edit");

      jMenuEchelle.setText("Change l'echelle");
      jMenuEchelle.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuEchelleActionPerformed(evt);
         }
      });
      jMenu2.add(jMenuEchelle);

      jMenuRecader.setText("Recadrer");
      jMenuRecader.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuRecaderActionPerformed(evt);
         }
      });
      jMenu2.add(jMenuRecader);

      jMenuSeamCav.setText("Seam caving");
      jMenuSeamCav.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuSeamCavActionPerformed(evt);
         }
      });
      jMenu2.add(jMenuSeamCav);

      jMenuBar1.add(jMenu2);

      setJMenuBar(jMenuBar1);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
               .addComponent(btnRed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(btnBlue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(btnGreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(jSliderResizer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(btnRefresh)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(btnRed)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(btnGreen)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(btnBlue)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jSliderResizer, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents


    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        jSliderResizer.setValue(50);
        File file = new File(System.getProperty("user.home"), "Desktop");
        JFileChooser fileChooser = new JFileChooser(file);

        fileChooser.setDialogTitle("Open Resource File");
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and GIF images", "png", "gif","jpg");
        fileChooser.addChoosableFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            System.out.println(fileChooser.getSelectedFile().getPath());
            try {
                imgPath = fileChooser.getSelectedFile().getPath();
                InputStream targetStream = new FileInputStream(imgPath);
                img = ImageIO.read(targetStream);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            icon = new ImageIcon(img);
				lblImage.setIcon(icon);
				
//            width = img.getWidth();
//            height = img.getHeight();
//            lbl.setSize(width, height);
//            lbl.setIcon(icon);
//            lbl.setLocation(120, 0);
            //lbl.setLocation(850, 40);

        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuClearActionPerformed
        lblImage.setIcon(null);
        jSliderResizer.setValue(50);
//        if (lbl.getIcon() != null) {
//            lbl.setIcon(null);
//            img = null;
//            jSliderResizer.setValue(50);
//        }
    }//GEN-LAST:event_jMenuClearActionPerformed

    private void jMenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuExitActionPerformed

    private void jSliderResizerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderResizerStateChanged
        if (img != null) {
            if (jSliderResizer.getValue() != 50) {
					try {
                switch (imgOperations) {
                    case ECHELLE:
                       // changeEchelle();
                        refreshImage(resizing.changeEchelle());
                        break;
                    case RECADRAGE:
                        //recadrerImg();
                        refreshImage(recadrage.recadrerImg());
                        break;
                }
					} catch (IllegalArgumentException ex) {
						
					}
            } else {
                icon = new ImageIcon(img);
                width = img.getWidth();
                height = img.getHeight();
                //lbl.setSize(width, height);
                //lbl.setIcon(icon);
                lblImage.setIcon(icon);
            }
        }
    }//GEN-LAST:event_jSliderResizerStateChanged

    private void btnRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedActionPerformed
       // colorsEnum = ColorsEnum.RED;
        //displayGrad();
        gradient = new DisplayGradient(colorsEnum.RED, this);
        refreshImage(gradient.displayGrad());
    }//GEN-LAST:event_btnRedActionPerformed

    private void jMenuEchelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEchelleActionPerformed
        jSliderResizer.setEnabled(true);
        imgOperations = ImageOperationsEnum.ECHELLE;
        jMenuEchelle.setBackground(Color.pink);
        jMenuRecader.setBackground(defaultBackground);
        jMenuSeamCav.setBackground(defaultBackground);
    }//GEN-LAST:event_jMenuEchelleActionPerformed

    private void jMenuRecaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRecaderActionPerformed
        jSliderResizer.setEnabled(true);
        imgOperations = ImageOperationsEnum.RECADRAGE;
        jMenuEchelle.setBackground(defaultBackground);
        jMenuRecader.setBackground(Color.pink);
        jMenuSeamCav.setBackground(defaultBackground);
    }//GEN-LAST:event_jMenuRecaderActionPerformed

    private void jMenuSeamCavActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSeamCavActionPerformed
        jSliderResizer.setEnabled(false);
        imgOperations = ImageOperationsEnum.SEAM_CAVING;
        jMenuEchelle.setBackground(defaultBackground);
        jMenuRecader.setBackground(defaultBackground);
        jMenuSeamCav.setBackground(Color.pink);
        seam.seamCaving();
    }//GEN-LAST:event_jMenuSeamCavActionPerformed

    private void btnGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGreenActionPerformed
       // colorsEnum = ColorsEnum.GREEN;
       // displayGrad();
       gradient = new DisplayGradient(colorsEnum.GREEN, this);
       refreshImage(gradient.displayGrad());
    }//GEN-LAST:event_btnGreenActionPerformed

    private void btnBlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlueActionPerformed
       //colorsEnum = ColorsEnum.BLUE;
       //displayGrad();
       gradient = new DisplayGradient(colorsEnum.BLUE, this);
       refreshImage(gradient.displayGrad());
    }//GEN-LAST:event_btnBlueActionPerformed
    
    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        InputStream targetStream;
        try {
            targetStream = new FileInputStream(imgPath);
            img = ImageIO.read(targetStream);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshImage(img);
        jSliderResizer.setValue(50);
    }//GEN-LAST:event_btnRefreshActionPerformed

   private void itemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSaveActionPerformed
		JFileChooser fileChooser = new JFileChooser(new File(System.getProperty("user.home"), "Desktop"));
      FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG images", "png");
      fileChooser.addChoosableFileFilter(filter);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setDialogTitle("Сохранить как...");
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			ByteArrayOutputStream bos = null;
			try {
				bos = new ByteArrayOutputStream();
				ImageIO.write(img, "png", bos);
				byte[] b = bos.toByteArray();
				
				FileOutputStream out = new FileOutputStream(fileChooser.getSelectedFile());
				out.write(b);
				out.close();
				
			} catch (IOException e) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
			} finally {
				try {
					bos.close();
				} catch (IOException e) {}
			}
		}	
   }//GEN-LAST:event_itemSaveActionPerformed

    private void refreshImage(BufferedImage img) {
        icon = new ImageIcon(img);
        //lbl.setSize(img.getWidth(), img.getHeight());
        //lbl.setIcon(icon);
        lblImage.setIcon(icon);
    }
    
   // <editor-fold defaultstate="collapsed" desc="user-description"> 
    public int getWIDTH() {
        return width;
    }

    public int getHEIGHT() {
        return height;
    }

    public int getPrecent() {
        return precent;
    }

    public void setPrecent(int precent) {
        this.precent = precent;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
   // </editor-fold> 
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnBlue;
   private javax.swing.JButton btnGreen;
   private javax.swing.JButton btnRed;
   private javax.swing.JButton btnRefresh;
   private javax.swing.JMenuItem itemSave;
   private javax.swing.JMenu jMenu1;
   private javax.swing.JMenu jMenu2;
   private javax.swing.JMenuBar jMenuBar1;
   private javax.swing.JMenuItem jMenuClear;
   private javax.swing.JMenuItem jMenuEchelle;
   private javax.swing.JMenuItem jMenuExit;
   private javax.swing.JMenuItem jMenuItem1;
   private javax.swing.JMenuItem jMenuRecader;
   private javax.swing.JMenuItem jMenuSeamCav;
   private javax.swing.JPanel jPanel1;
   protected javax.swing.JSlider jSliderResizer;
   javax.swing.JLabel lblImage;
   // End of variables declaration//GEN-END:variables
}
