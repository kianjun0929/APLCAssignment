/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.Main;
import Classes.Services;
import Classes.ServicesFactory;
import Helpers.PrologConnection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kian Jun
 */
public class SortExpenditureWithProlog extends javax.swing.JFrame {
    
    List<Services> listServices;
    List<Services> servicesList = new ArrayList();
    List<String> listString = new ArrayList();
    DefaultTableModel tableModel;
    PrologConnection prologConnection;
    int selectedYear;
    
    public SortExpenditureWithProlog() throws Exception {
        initComponents();
        setLocationRelativeTo(null);
        listServices = Main.getListServices();
        tableModel = (DefaultTableModel) jTable1.getModel();
        prologConnection = new PrologConnection("quicksortAsc.pl");
        selectedYear = 2005;
    }
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        btnAverageExpenditure = new javax.swing.JButton();
        btnFilterExpenditure = new javax.swing.JButton();
        btnHighestLowestExpenditure = new javax.swing.JButton();
        btnSortingCategory = new javax.swing.JButton();
        btnTotalAnnual = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCompute = new javax.swing.JButton();
        checkBoxCountrySpecificTourismCharacteristics = new javax.swing.JCheckBox();
        checkBoxAccommodation = new javax.swing.JCheckBox();
        rbtn2005 = new javax.swing.JRadioButton();
        rbtn2006 = new javax.swing.JRadioButton();
        rbtn2007 = new javax.swing.JRadioButton();
        rbtn2008 = new javax.swing.JRadioButton();
        rbtn2009 = new javax.swing.JRadioButton();
        rbtn2010 = new javax.swing.JRadioButton();
        rbtn2011 = new javax.swing.JRadioButton();
        rbtn2012 = new javax.swing.JRadioButton();
        rbtn2013 = new javax.swing.JRadioButton();
        rbtn2014 = new javax.swing.JRadioButton();
        rbtn2015 = new javax.swing.JRadioButton();
        rbtn2016 = new javax.swing.JRadioButton();
        rbtn2017 = new javax.swing.JRadioButton();
        rbtn2018 = new javax.swing.JRadioButton();
        checkBoxFoodAndBeverage = new javax.swing.JCheckBox();
        checkBoxPassengerTransport = new javax.swing.JCheckBox();
        checkBoxCulturalSportsAndRecreational = new javax.swing.JCheckBox();
        checkBoxTravelAgenciesAndOtherReservation = new javax.swing.JCheckBox();
        checkBoxCountrySpecificTourismCharacteristicGoods = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 750));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 750));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1200, 750));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 750));
        jPanel1.setLayout(null);

        jLabel33.setFont(new java.awt.Font("Academy Engraved LET", 1, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 0, 0));
        jLabel33.setText("X");
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel33MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel33);
        jLabel33.setBounds(20, 10, 40, 40);

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        jPanel1.add(btnHome);
        btnHome.setBounds(10, 50, 110, 40);

        btnAverageExpenditure.setText("Average Expenditure");
        btnAverageExpenditure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAverageExpenditureActionPerformed(evt);
            }
        });
        jPanel1.add(btnAverageExpenditure);
        btnAverageExpenditure.setBounds(140, 50, 160, 40);

        btnFilterExpenditure.setText("Filter Expenditure");
        btnFilterExpenditure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterExpenditureActionPerformed(evt);
            }
        });
        jPanel1.add(btnFilterExpenditure);
        btnFilterExpenditure.setBounds(330, 50, 160, 40);

        btnHighestLowestExpenditure.setText("Highest or Lowest Expenditure");
        btnHighestLowestExpenditure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHighestLowestExpenditureActionPerformed(evt);
            }
        });
        jPanel1.add(btnHighestLowestExpenditure);
        btnHighestLowestExpenditure.setBounds(520, 50, 220, 40);

        btnSortingCategory.setForeground(new java.awt.Color(51, 51, 255));
        btnSortingCategory.setText("Sorting Category");
        btnSortingCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortingCategoryActionPerformed(evt);
            }
        });
        jPanel1.add(btnSortingCategory);
        btnSortingCategory.setBounds(760, 50, 160, 40);

        btnTotalAnnual.setText("Total Annual");
        btnTotalAnnual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalAnnualActionPerformed(evt);
            }
        });
        jPanel1.add(btnTotalAnnual);
        btnTotalAnnual.setBounds(940, 50, 160, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Category");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(240, 160, 100, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Year");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 160, 100, 40);

        btnCompute.setText("Compute");
        btnCompute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComputeActionPerformed(evt);
            }
        });
        jPanel1.add(btnCompute);
        btnCompute.setBounds(30, 490, 490, 40);

        checkBoxCountrySpecificTourismCharacteristics.setText("Country-specific Tourism Characterics");
        jPanel1.add(checkBoxCountrySpecificTourismCharacteristics);
        checkBoxCountrySpecificTourismCharacteristics.setBounds(240, 450, 280, 25);

        checkBoxAccommodation.setText("Accommodation");
        checkBoxAccommodation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxAccommodationActionPerformed(evt);
            }
        });
        jPanel1.add(checkBoxAccommodation);
        checkBoxAccommodation.setBounds(240, 210, 180, 25);

        buttonGroup3.add(rbtn2005);
        rbtn2005.setSelected(true);
        rbtn2005.setText("2005");
        rbtn2005.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn2005ActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn2005);
        rbtn2005.setBounds(30, 210, 57, 25);

        buttonGroup3.add(rbtn2006);
        rbtn2006.setText("2006");
        rbtn2006.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn2006ActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn2006);
        rbtn2006.setBounds(30, 250, 57, 25);

        buttonGroup3.add(rbtn2007);
        rbtn2007.setText("2007");
        rbtn2007.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn2007ActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn2007);
        rbtn2007.setBounds(30, 290, 57, 25);

        buttonGroup3.add(rbtn2008);
        rbtn2008.setText("2008");
        rbtn2008.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn2008ActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn2008);
        rbtn2008.setBounds(30, 330, 57, 25);

        buttonGroup3.add(rbtn2009);
        rbtn2009.setText("2009");
        rbtn2009.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn2009ActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn2009);
        rbtn2009.setBounds(30, 370, 57, 25);

        buttonGroup3.add(rbtn2010);
        rbtn2010.setText("2010");
        rbtn2010.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn2010ActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn2010);
        rbtn2010.setBounds(30, 410, 57, 25);

        buttonGroup3.add(rbtn2011);
        rbtn2011.setText("2011");
        rbtn2011.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn2011ActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn2011);
        rbtn2011.setBounds(30, 450, 57, 25);

        buttonGroup3.add(rbtn2012);
        rbtn2012.setText("2012");
        rbtn2012.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn2012ActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn2012);
        rbtn2012.setBounds(140, 210, 57, 25);

        buttonGroup3.add(rbtn2013);
        rbtn2013.setText("2013");
        rbtn2013.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn2013ActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn2013);
        rbtn2013.setBounds(140, 250, 57, 25);

        buttonGroup3.add(rbtn2014);
        rbtn2014.setText("2014");
        rbtn2014.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn2014ActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn2014);
        rbtn2014.setBounds(140, 290, 57, 25);

        buttonGroup3.add(rbtn2015);
        rbtn2015.setText("2015");
        rbtn2015.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn2015ActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn2015);
        rbtn2015.setBounds(140, 330, 57, 25);

        buttonGroup3.add(rbtn2016);
        rbtn2016.setText("2016");
        rbtn2016.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn2016ActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn2016);
        rbtn2016.setBounds(140, 370, 57, 25);

        buttonGroup3.add(rbtn2017);
        rbtn2017.setText("2017");
        rbtn2017.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn2017ActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn2017);
        rbtn2017.setBounds(140, 410, 57, 25);

        buttonGroup3.add(rbtn2018);
        rbtn2018.setText("2018");
        rbtn2018.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn2018ActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn2018);
        rbtn2018.setBounds(140, 450, 57, 25);

        checkBoxFoodAndBeverage.setText("Food And Beverage");
        jPanel1.add(checkBoxFoodAndBeverage);
        checkBoxFoodAndBeverage.setBounds(240, 250, 180, 25);

        checkBoxPassengerTransport.setText("Passenger Transport");
        jPanel1.add(checkBoxPassengerTransport);
        checkBoxPassengerTransport.setBounds(240, 290, 180, 25);

        checkBoxCulturalSportsAndRecreational.setText("Cultural, Sports, and Recreational");
        jPanel1.add(checkBoxCulturalSportsAndRecreational);
        checkBoxCulturalSportsAndRecreational.setBounds(240, 330, 280, 25);

        checkBoxTravelAgenciesAndOtherReservation.setText("Travel Agencies and other Reservation");
        jPanel1.add(checkBoxTravelAgenciesAndOtherReservation);
        checkBoxTravelAgenciesAndOtherReservation.setBounds(240, 370, 280, 25);

        checkBoxCountrySpecificTourismCharacteristicGoods.setText("Country-specific Tourism Characteric Goods");
        jPanel1.add(checkBoxCountrySpecificTourismCharacteristicGoods);
        checkBoxCountrySpecificTourismCharacteristicGoods.setBounds(240, 410, 280, 25);

        jTable1.setBackground(new java.awt.Color(0, 0, 0));
        jTable1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category", "Amount (RM)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 153, 255));
        jTable1.setRowHeight(35);
        jTable1.setRowMargin(3);
        jTable1.setSelectionBackground(new java.awt.Color(255, 0, 0));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(540, 250, 560, 280);

        txtTotal.setEditable(false);
        jPanel1.add(txtTotal);
        txtTotal.setBounds(910, 200, 100, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("million(s)");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(1020, 200, 80, 40);

        jLabel27.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 0, 102));
        jLabel27.setText("The total annual expenditure and sort the expenditure from lowest to highest");
        jPanel1.add(jLabel27);
        jLabel27.setBounds(20, 110, 910, 50);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Total (RM):");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(820, 200, 90, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTotalAnnualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalAnnualActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new TotalAnnual().setVisible(true);
    }//GEN-LAST:event_btnTotalAnnualActionPerformed

    private void btnSortingCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortingCategoryActionPerformed
        // TODO add your handling code here:
        this.dispose();
        try {
            new SortExpenditureWithProlog().setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(SortExpenditureWithProlog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSortingCategoryActionPerformed

    private void btnHighestLowestExpenditureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHighestLowestExpenditureActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new HighestLowestExpenditure().setVisible(true);
    }//GEN-LAST:event_btnHighestLowestExpenditureActionPerformed

    private void btnFilterExpenditureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterExpenditureActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new FilterExpenditure().setVisible(true);
    }//GEN-LAST:event_btnFilterExpenditureActionPerformed

    private void btnAverageExpenditureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAverageExpenditureActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new AverageExpenditure().setVisible(true);
    }//GEN-LAST:event_btnAverageExpenditureActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Home().setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel33MouseClicked

    private void btnComputeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComputeActionPerformed
        // TODO add your handling code here:
        checkboxChecker();
        getTotal();
        listString.clear();
    }//GEN-LAST:event_btnComputeActionPerformed

    private void rbtn2005ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn2005ActionPerformed
        // TODO add your handling code here:
        selectedYear = 2005;
    }//GEN-LAST:event_rbtn2005ActionPerformed

    private void rbtn2006ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn2006ActionPerformed
        // TODO add your handling code here:
        selectedYear = 2006;
    }//GEN-LAST:event_rbtn2006ActionPerformed

    private void rbtn2007ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn2007ActionPerformed
        // TODO add your handling code here:
        selectedYear = 2007;
    }//GEN-LAST:event_rbtn2007ActionPerformed

    private void rbtn2008ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn2008ActionPerformed
        // TODO add your handling code here:
        selectedYear = 2008;
    }//GEN-LAST:event_rbtn2008ActionPerformed

    private void rbtn2009ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn2009ActionPerformed
        // TODO add your handling code here:
        selectedYear = 2009;
    }//GEN-LAST:event_rbtn2009ActionPerformed

    private void rbtn2010ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn2010ActionPerformed
        // TODO add your handling code here:
        selectedYear = 2010;
    }//GEN-LAST:event_rbtn2010ActionPerformed

    private void rbtn2011ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn2011ActionPerformed
        // TODO add your handling code here:
        selectedYear = 2011;
    }//GEN-LAST:event_rbtn2011ActionPerformed

    private void rbtn2012ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn2012ActionPerformed
        // TODO add your handling code here:
        selectedYear = 2012;
    }//GEN-LAST:event_rbtn2012ActionPerformed

    private void rbtn2013ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn2013ActionPerformed
        // TODO add your handling code here:
        selectedYear = 2013;
    }//GEN-LAST:event_rbtn2013ActionPerformed

    private void rbtn2014ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn2014ActionPerformed
        // TODO add your handling code here:
        selectedYear = 2014;
    }//GEN-LAST:event_rbtn2014ActionPerformed

    private void rbtn2015ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn2015ActionPerformed
        // TODO add your handling code here:
        selectedYear = 2015;
    }//GEN-LAST:event_rbtn2015ActionPerformed

    private void rbtn2016ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn2016ActionPerformed
        // TODO add your handling code here:
        selectedYear = 2016;
    }//GEN-LAST:event_rbtn2016ActionPerformed

    private void rbtn2017ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn2017ActionPerformed
        // TODO add your handling code here:
        selectedYear = 2017;
    }//GEN-LAST:event_rbtn2017ActionPerformed

    private void rbtn2018ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn2018ActionPerformed
        // TODO add your handling code here:
        selectedYear = 2018;
    }//GEN-LAST:event_rbtn2018ActionPerformed

    private void checkBoxAccommodationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxAccommodationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxAccommodationActionPerformed

    private void checkboxChecker() {
        if(checkBoxAccommodation.isSelected()) {
            servicesList.add(ServicesFactory.getServices("Accommodation"));
        }
        if(checkBoxFoodAndBeverage.isSelected()) {
            servicesList.add(ServicesFactory.getServices("Food and Beverage"));
        }
        if(checkBoxPassengerTransport.isSelected()) {
            servicesList.add(ServicesFactory.getServices("Passenger Transport"));
        }
        if(checkBoxCulturalSportsAndRecreational.isSelected()) {
            servicesList.add(ServicesFactory.getServices("Cultural, Sports, and Recreational"));
        }
        if(checkBoxTravelAgenciesAndOtherReservation.isSelected()) {
            servicesList.add(ServicesFactory.getServices("Travel Agencies and Other Reservation"));
        }
        if(checkBoxCountrySpecificTourismCharacteristicGoods.isSelected()) {
            servicesList.add(ServicesFactory.getServices("Country-Specific Tourism Characteristic Goods"));
        }
        if(checkBoxCountrySpecificTourismCharacteristics.isSelected()) {
            servicesList.add(ServicesFactory.getServices("Country-Specific Tourism Characteristics"));
        }
    }
    
    private void getTotal() {
        List<String> listCategoryAmount = new ArrayList();
        //Prevent none of services is being selected
        if(!servicesList.isEmpty()) {
            //Get the total based on the category and year
            servicesList.stream().forEach(service -> Main.totalAnnual(listServices, service, selectedYear));
            //Populate into a list of String for sorting purpose
            Main.getListServicesForTotal()
                    .entrySet()
                    .stream()
                    .forEach(item -> listString.add("('" + item.getKey() + "', " + item.getValue() + ")"));
            //Populate into a list of String for totaling purpose
            Main.getListServicesForTotal()
                    .entrySet()
                    .stream()
                    .forEach(item -> listCategoryAmount.add(item.getValue().toString()));
            //Get the sum from prolog and set the value to txtTotal
            txtTotal.setText(Main.df.format(prologConnection.sum(listCategoryAmount.toString())));
            //Populate into the table
            populateToModel();
            //Clear all the previous records
            Main.getListServicesForTotal().clear();
            listString.clear();
            servicesList.clear();
        }
        
    }
    
     private void populateToModel() {
         //Remove the previous records
        tableModel.setRowCount(0);
        //Add as row into the table after sorting
        prologConnection.sort(listString)
                .entrySet()
                .stream()
                .forEach(item -> tableModel.addRow(new Object[]{item.getKey(), item.getValue().toString()}));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SortExpenditureWithProlog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SortExpenditureWithProlog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SortExpenditureWithProlog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SortExpenditureWithProlog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SortExpenditureWithProlog().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(SortExpenditureWithProlog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAverageExpenditure;
    private javax.swing.JButton btnCompute;
    private javax.swing.JButton btnFilterExpenditure;
    private javax.swing.JButton btnHighestLowestExpenditure;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSortingCategory;
    private javax.swing.JButton btnTotalAnnual;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JCheckBox checkBoxAccommodation;
    private javax.swing.JCheckBox checkBoxCountrySpecificTourismCharacteristicGoods;
    private javax.swing.JCheckBox checkBoxCountrySpecificTourismCharacteristics;
    private javax.swing.JCheckBox checkBoxCulturalSportsAndRecreational;
    private javax.swing.JCheckBox checkBoxFoodAndBeverage;
    private javax.swing.JCheckBox checkBoxPassengerTransport;
    private javax.swing.JCheckBox checkBoxTravelAgenciesAndOtherReservation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rbtn2005;
    private javax.swing.JRadioButton rbtn2006;
    private javax.swing.JRadioButton rbtn2007;
    private javax.swing.JRadioButton rbtn2008;
    private javax.swing.JRadioButton rbtn2009;
    private javax.swing.JRadioButton rbtn2010;
    private javax.swing.JRadioButton rbtn2011;
    private javax.swing.JRadioButton rbtn2012;
    private javax.swing.JRadioButton rbtn2013;
    private javax.swing.JRadioButton rbtn2014;
    private javax.swing.JRadioButton rbtn2015;
    private javax.swing.JRadioButton rbtn2016;
    private javax.swing.JRadioButton rbtn2017;
    private javax.swing.JRadioButton rbtn2018;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
