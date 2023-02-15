package presentationLayer;

import businessLayer.BaseProduct;
import businessLayer.ControllerView;
import businessLayer.MenuItem;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class ClientView extends javax.swing.JFrame {
    ArrayList<BaseProduct> baseProducts = new ArrayList<>();
    public ClientView() {
        initComponents();


    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        searchByField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        productNameField = new javax.swing.JTextField();
        addToCartButton = new javax.swing.JButton();
        viewCartButton = new javax.swing.JButton();
        menusButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setForeground(new java.awt.Color(204, 255, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setText("FOOD DELIVERY MANAGEMENT SYSTEM");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null}
                },
                new String [] {
                        "Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"
                }
        ));
        jScrollPane2.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All products", "Menus", "title", "rating", "calories", "protein", "fat", "sodium", "price" }));
        jComboBox1.setToolTipText("Search by");

        searchButton.setText("Search");

        addToCartButton.setText("Add to cart");

        viewCartButton.setText("View cart");

        menusButton.setText("Menus");

        backButton.setText("Back");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(174, 174, 174)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33)
                                                .addComponent(searchByField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(40, 40, 40)
                                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(272, 272, 272)
                                                .addComponent(productNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(21, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(menusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(157, 157, 157)
                                .addComponent(addToCartButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(viewCartButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(backButton)
                                .addGap(5, 5, 5))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(130, 130, 130))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchByField)
                                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(productNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(addToCartButton)
                                                        .addComponent(viewCartButton)
                                                        .addComponent(menusButton))
                                                .addContainerGap(22, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(backButton)
                                                .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    public void table(ArrayList<BaseProduct> baseProducts) {
            DefaultTableModel df= (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            for(BaseProduct baseProduct: baseProducts) {
                Vector<String > v2 = new Vector<>();
                    v2.add(baseProduct.getTitle());
                    v2.add(String.valueOf(baseProduct.getRating()));
                    v2.add(String.valueOf(baseProduct.getCalories()));
                    v2.add(String.valueOf(baseProduct.getProtein()));
                    v2.add(String.valueOf(baseProduct.getFat()));
                    v2.add(String.valueOf(baseProduct.getSodium()));
                    v2.add(String.valueOf(baseProduct.getPrice()));
                df.addRow(v2);
            }
    }
    public String jTable1MouseClicked() {
        DefaultTableModel d1= (DefaultTableModel)jTable1.getModel();
        int SelectIndex=jTable1.getSelectedRow();
        return d1.getValueAt(SelectIndex,0).toString();
    }
    public void addSearchListener(ActionListener searchListener){
       searchButton.addActionListener(searchListener);
   }
    public void addAddToCartListener(ActionListener addCartListener){addToCartButton.addActionListener(addCartListener);}
    public void addViewCartListener(ActionListener addViewListener){viewCartButton.addActionListener(addViewListener);}
    public void addMenuListener(ActionListener menuListener){menusButton.addActionListener(menuListener);}
    public void addBackListener(ActionListener actionListener){this.backButton.addActionListener(actionListener);}

    public void setProductNameField(String productNameField) {
        this.productNameField.setText(productNameField);
    }
    public void setSearchField(String searchField){ this.searchByField.setText(searchField);}
    public String getProductNameField() {
        return this.productNameField.getText();
    }
    public String getSearchField(){ return this.searchByField.getText();}
    public String getSearchingMode(){ return (String)this.jComboBox1.getSelectedItem();}
    public void addTableListener(ControllerView.tableClicked event){jTable1.addMouseListener(event);}

    // Variables declaration - do not modify
    private javax.swing.JButton addToCartButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField productNameField;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField searchByField;
    private javax.swing.JButton menusButton;
    private javax.swing.JButton viewCartButton;



    // End of variables declaration
}
