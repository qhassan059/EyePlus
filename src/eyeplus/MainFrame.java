package eyeplus;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
public class MainFrame extends JFrame {
    
    DatabaseConn connection = new DatabaseConn();
    String CusName, ContactNumber, Address,gender;
    String RSPH,RCYL,RAXIS,RVD,RNearAdd,RVN;
    String LSPH,LCYL,LAXIS,LVD,LNearAdd,LVN;
    String LensType, LensFor;
    int Age, CusID=0,LensPrice=0,FramePrice=0;
    private JButton SaveButton = new JButton();
    private JButton ClearButton = new JButton();
    private JButton InsertButton = new JButton();
    private JTextField LensPriceTF = new JTextField();
    private JTextField FramePriceTF = new JTextField();
    DefaultTableModel model;
    DefaultTableModel model1;
    public MainFrame() {
        CusName=null;
        Address =null;
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        setSize(xsize,ysize);
        handler h = new handler();
        SaveButton.addActionListener(h);
        ClearButton.addActionListener(h);
        InsertButton.addActionListener(h);
        model = new DefaultTableModel();
                model = (DefaultTableModel)CustomerRecordTable.getModel();
                ArrayList<CustomerDetails> customers = connection.getDataFromCus();
                Object[][] obje = new Object[customers.size()][6];
                System.out.println("De");
                for(int i=0; i<customers.size(); i++){
                    model.addRow(customers.get(i).toArray());
        }
        
        model1 = (DefaultTableModel)PresTable.getModel();
        ArrayList<PresDetails> pres = connection.getDataFromPres();
        for(int i=0;i<pres.size(); i ++)
            model1.addRow(pres.get(i).toArrays());
    }
    private class handler implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            DatabaseConn con = new DatabaseConn();
            
            if(evt.getSource()==SaveButton){
                CusName=CustomerNameTF.getText();
                ContactNumber=ContactTF.getText();
                if(male.isSelected()){
                    gender = "male";
                }
                else{
                    gender = "female";
                }
                
                try{
                    Age=Integer.parseInt(AgeTF.getText());
                }
                
                catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(new JFrame("Message"),"Enter Integer Value");
                }
                Address=AddressTF.getText();
                //Gender Not selected here;
                con.insertCus(CusName, ContactNumber, Age, Address, gender);
                //addign record in table  -->
                
                Object[] obj = con.getLast().toArray();
                model.addRow(obj);
                
            }
            else if(evt.getSource()==ClearButton){
                CustomerNameTF.setText(null);
                ContactTF.setText(null);
                AgeTF.setText("");
                AddressTF.setText(null);
            }
            else if(evt.getSource()==InsertButton){
                //Right Eye Prescription
                RSPH = (String)(RSPHJComboBox.getItemAt(RSPHJComboBox.getSelectedIndex()));
                RCYL = (String)(RCYLJComboBox.getItemAt(RCYLJComboBox.getSelectedIndex()));
                RAXIS = (String)(RAxisComboBox.getItemAt(RAxisComboBox.getSelectedIndex()));
                RVD = (String)(RVDComboBox.getItemAt(RVDComboBox.getSelectedIndex()));
                RNearAdd = (String)(RNearAddComboBox.getItemAt(RNearAddComboBox.getSelectedIndex()));
                RVN = (String)(RVDComboBox.getItemAt(RVNComboBox.getSelectedIndex()));
                //Left eye prescription
                LSPH = (String)(LSPHJComboBox1.getItemAt(LSPHJComboBox1.getSelectedIndex()));
                LCYL = (String)(LCYLJComboBox1.getItemAt(LCYLJComboBox1.getSelectedIndex()));
                LAXIS = (String)(LAxisComboBox1.getItemAt(LAxisComboBox1.getSelectedIndex()));
                LVD = (LVDComboBox1.getItemAt(LVDComboBox1.getSelectedIndex()));
                LNearAdd = (LNearAddComboBox1.getItemAt(LNearAddComboBox1.getSelectedIndex()));
                LVN = (LVDComboBox1.getItemAt(LVNComboBox1.getSelectedIndex()));
                LensType = (LensTypejComboBox.getItemAt(LensTypejComboBox.getSelectedIndex()));
                LensFor = (LensForjComboBox1.getItemAt(LensForjComboBox1.getSelectedIndex()));
                try{
                    LensPrice = Integer.parseInt(LensPriceTF.getText());
                    
                }
                catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(new JFrame("Message"),"Enter Integer Value");
                }
                try {
                    FramePrice = Integer.parseInt(FramePriceTF.getText());
                }
                catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(new JFrame("Message"),"Enter Integer Value");
                }
                String PaidAmount = PaidAmountTF.getText();
            String FrameType = FrameTypeTF.getText();
            String TotalAmount = TotalAmountTF.getText();
            String PendingAmount = PendingAmountTF.getText();
            int cid = Integer.parseInt(CIDTF.getText());
            if(PaidAmount.equals("") || FrameType.equals("") || TotalAmount.equals("") || PendingAmount.equals("")){
                JOptionPane.showMessageDialog(null, "Please insert the Blanks");
                return;
            }
            
            //Lens_price,Frame_price, Frame_type, Paid_Amount, Total_Amount,Pending_Amoun

            PresDetails pres = new PresDetails(cid, RSPH,  LSPH,   RCYL,   LCYL,    RAXIS, LAXIS,  RVD,  LVD, RNearAdd, LNearAdd,  RVN,  LVN, LensType, LensFor, LensPrice,  FramePrice, FrameType, Integer.parseInt(PaidAmount), Integer.parseInt(TotalAmount), Integer.parseInt(PendingAmount));
            connection.insertPresc(pres);
            DefaultTableModel model1 = (DefaultTableModel)PresTable.getModel();
            model1.addRow(pres.toArrays());
            
            }            
        }
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        AddNewInfoPanel = new javax.swing.JPanel();
        CustomerNameLabel = new javax.swing.JLabel();
        CustomerNameTF = new javax.swing.JTextField();
        ContactLabel = new javax.swing.JLabel();
        ContactTF = new javax.swing.JTextField();
        AddressLabel = new javax.swing.JLabel();
        AgeTF = new javax.swing.JTextField();
        AgeLabel = new javax.swing.JLabel();
        AddressTF = new javax.swing.JTextField();
        GenderLabel = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        AddNewPerscriptionPanel = new javax.swing.JPanel();
        CustomerIDLabel = new javax.swing.JLabel();
        PercriptonIDLabl = new javax.swing.JLabel();
        PrescriptionIDTF = new javax.swing.JTextField();
        NoteVarLabel = new javax.swing.JLabel();
        AddNewPriscriptionPanel = new javax.swing.JPanel();
        EyeLabel = new javax.swing.JLabel();
        RightEyeLabel = new javax.swing.JLabel();
        LeftEyeLabel = new javax.swing.JLabel();
        SPHLabel = new javax.swing.JLabel();
        CYLLABEL = new javax.swing.JLabel();
        AxisLabel = new javax.swing.JLabel();
        VDLabel = new javax.swing.JLabel();
        NearAddLabel = new javax.swing.JLabel();
        RSPHJComboBox = new javax.swing.JComboBox<>();
        RCYLJComboBox = new javax.swing.JComboBox<>();
        RAxisComboBox = new javax.swing.JComboBox<>();
        RVDComboBox = new javax.swing.JComboBox<>();
        RNearAddComboBox = new javax.swing.JComboBox<>();
        RVNComboBox = new javax.swing.JComboBox<>();
        LSPHJComboBox1 = new javax.swing.JComboBox<>();
        LCYLJComboBox1 = new javax.swing.JComboBox<>();
        LAxisComboBox1 = new javax.swing.JComboBox<>();
        LVDComboBox1 = new javax.swing.JComboBox<>();
        LNearAddComboBox1 = new javax.swing.JComboBox<>();
        LVNComboBox1 = new javax.swing.JComboBox<>();
        VnLabel = new javax.swing.JLabel();
        LensTypeLabel = new javax.swing.JLabel();
        LensTypejComboBox = new javax.swing.JComboBox<>();
        LensForLabel = new javax.swing.JLabel();
        LensForjComboBox1 = new javax.swing.JComboBox<>();
        LensPriceLabel = new javax.swing.JLabel();
        LensPriceTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        FramePriceTF = new javax.swing.JTextField();
        FrameTypeLabel = new javax.swing.JLabel();
        FrameTypeTF = new javax.swing.JTextField();
        PaidAmountLabel = new javax.swing.JLabel();
        PaidAmountTF = new javax.swing.JTextField();
        TotalAmountLabel = new javax.swing.JLabel();
        TotalAmountTF = new javax.swing.JTextField();
        PendingAmountLabel = new javax.swing.JLabel();
        PendingAmountTF = new javax.swing.JTextField();
        InsertButton = new javax.swing.JButton();
        pUpdateBtn = new javax.swing.JButton();
        PriscriptionClearButton = new javax.swing.JButton();
        pDeleteBtn = new javax.swing.JButton();
        EyeDetailLabel = new javax.swing.JLabel();
        CIDTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        CustomerRecordTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        PresTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));

        AddNewInfoPanel.setBackground(new java.awt.Color(255, 255, 255));
        AddNewInfoPanel.setForeground(new java.awt.Color(255, 255, 255));

        CustomerNameLabel.setText("Name");

        CustomerNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerNameTFActionPerformed(evt);
            }
        });

        ContactLabel.setText("Contact No");

        ContactTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactTFActionPerformed(evt);
            }
        });

        AddressLabel.setText("Address");

        AgeTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgeTFActionPerformed(evt);
            }
        });

        AgeLabel.setText("Age");

        GenderLabel.setText("Gender");

        SaveButton.setText("Save");


        ClearButton.setText("Clear");

        UpdateButton.setText("Select");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        male.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(male);
        male.setText("Male");

        female.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(female);
        female.setText("Female");

        javax.swing.GroupLayout AddNewInfoPanelLayout = new javax.swing.GroupLayout(AddNewInfoPanel);
        AddNewInfoPanel.setLayout(AddNewInfoPanelLayout);
        AddNewInfoPanelLayout.setHorizontalGroup(
            AddNewInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddNewInfoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SaveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ClearButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UpdateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddNewInfoPanelLayout.createSequentialGroup()
                .addGroup(AddNewInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(AddNewInfoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(GenderLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(male)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(female))
                    .addGroup(AddNewInfoPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(CustomerNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CustomerNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(ContactLabel))
                    .addGroup(AddNewInfoPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(AgeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AgeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AddressLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddNewInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AddressTF, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(ContactTF))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        AddNewInfoPanelLayout.setVerticalGroup(
            AddNewInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddNewInfoPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(AddNewInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CustomerNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CustomerNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ContactLabel)
                    .addComponent(ContactTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AddNewInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AgeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgeLabel)
                    .addComponent(AddressTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddressLabel))
                .addGap(18, 18, 18)
                .addGroup(AddNewInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GenderLabel)
                    .addComponent(male)
                    .addComponent(female))
                .addGap(38, 38, 38)
                .addGroup(AddNewInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(ClearButton)
                    .addComponent(UpdateButton)
                    .addComponent(DeleteButton))
                .addContainerGap(140, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("(+) Add New Information", AddNewInfoPanel);

        AddNewPerscriptionPanel.setBackground(new java.awt.Color(255, 255, 255));
        AddNewPerscriptionPanel.setForeground(new java.awt.Color(255, 255, 255));

        CustomerIDLabel.setText("Customer ID");

        PercriptonIDLabl.setText("Perscription ID");

        PrescriptionIDTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrescriptionIDTFActionPerformed(evt);
            }
        });

        NoteVarLabel.setText("*Only use for updation of the customer");

        AddNewPriscriptionPanel.setBackground(new java.awt.Color(255, 255, 255));

        EyeLabel.setText("Eye");

        RightEyeLabel.setText("Right");

        LeftEyeLabel.setText("Left");

        SPHLabel.setText("SPH");

        CYLLABEL.setText("CYL");

        AxisLabel.setText("AXIS");

        VDLabel.setText("VD");

        NearAddLabel.setText("Near Add");

        RSPHJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-8.00", "-7.75", "-7.50", "-7.25", "-7.00", "-6.75", "-6.50", "-6.25", "-6.00", "-5.75", "-5.50", "-5.25", "-5.00", "-4.75", "-4.50", "-4.25", "-4.00", "-3.75", "-3.50", "-3.25", "-3.00", "-2.75", "-2.50", "-2.25", "-2.00", "-1.75", "-1.50", "-1.25", "-1.00", "-0.75", "-0.50", "-0.25", "0.00", "8.00", "7.75", "7.50", "7.25", "7.00", "6.75", "6.50", "6.25", "6.00", "5.75", "5.50", "5.25", "5.00", "4.75", "4.50", "4.25", "4.00", "3.75", "3.50", "3.25", "3.00", "2.75", "2.50", "2.25", "2.00", "1.75", "1.50", "1.25", "1.00", "0.75", "0.50", "0.25" }));
        RSPHJComboBox.setToolTipText("SPH Right Eye");
        RSPHJComboBox.setPreferredSize(new java.awt.Dimension(50, 20));

        RCYLJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-8.00", "-7.75", "-7.50", "-7.25", "-7.00", "-6.75", "-6.50", "-6.25", "-6.00", "-5.75", "-5.50", "-5.25", "-5.00", "-4.75", "-4.50", "-4.25", "-4.00", "-3.75", "-3.50", "-3.25", "-3.00", "-2.75", "-2.50", "-2.25", "-2.00", "-1.75", "-1.50", "-1.25", "-1.00", "-0.75", "-0.50", "-0.25", "0.00", "8.00", "7.75", "7.50", "7.25", "7.00", "6.75", "6.50", "6.25", "6.00", "5.75", "5.50", "5.25", "5.00", "4.75", "4.50", "4.25", "4.00", "3.75", "3.50", "3.25", "3.00", "2.75", "2.50", "2.25", "2.00", "1.75", "1.50", "1.25", "1.00", "0.75", "0.50", "0.25" }));
        RCYLJComboBox.setMinimumSize(new java.awt.Dimension(50, 20));
        RCYLJComboBox.setPreferredSize(new java.awt.Dimension(50, 20));
        RCYLJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RCYLJComboBoxActionPerformed(evt);
            }
        });

        RAxisComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122", "123", "124", "125", "126", "127", "128", "129", "130", "131", "132", "133", "134", "135", "136", "137", "138", "139", "140", "141", "142", "143", "144", "145", "146", "147", "148", "149", "150", "151", "152", "153", "154", "155", "156", "157", "158", "159", "160", "161", "162", "163", "164", "165", "166", "167", "168", "169", "170", "171", "172", "173", "174", "175", "176", "177", "178", "179", "180", "181", "182", "183", "184", "185", "186", "187", "188", "189", "190", "191", "192", "193", "194", "195", "196", "197", "198", "199", "200", "201", "202", "203", "204", "205", "206", "207", "208", "209", "210", "211", "212", "213", "214", "215", "216", "217", "218", "219", "220", "221", "222", "223", "224", "225", "226", "227", "228", "229", "230", "231", "232", "233", "234", "235", "236", "237", "238", "239", "240", "241", "242", "243", "244", "245", "246", "247", "248", "249", "250", "251", "252", "253", "254", "255", "256", "257", "258", "259", "260", "261", "262", "263", "264", "265", "266", "267", "268", "269", "270", "271", "272", "273", "274", "275", "276", "277", "278", "279", "280", "281", "282", "283", "284", "285", "286", "287", "288", "289", "290", "291", "292", "293", "294", "295", "296", "297", "298", "299", "300", "301", "302", "303", "304", "305", "306", "307", "308", "309", "310", "311", "312", "313", "314", "315", "316", "317", "318", "319", "320", "321", "322", "323", "324", "325", "326", "327", "328", "329", "330", "331", "332", "333", "334", "335", "336", "337", "338", "339", "340", "341", "342", "343", "344", "345", "346", "347", "348", "349", "350", "351", "352", "353", "354", "355", "356", "357", "358", "359", "360" }));

        RVDComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6/6", "6/9", "6/12", "6/18", "6/24", "6/36" }));
        RVDComboBox.setMinimumSize(new java.awt.Dimension(50, 20));
        RVDComboBox.setPreferredSize(new java.awt.Dimension(50, 20));
        RVDComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RVDComboBoxActionPerformed(evt);
            }
        });

        RNearAddComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+1.00", "+1.25", "+1.50", "+1.75", "+2.00", "+2.25", "+2.50", "+2.75", "+3.00" }));

        RVNComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N-6", "N-8", "N-10", "N-12", "N-18", "N-24", "N-36" }));

        LSPHJComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-8.00", "-7.75", "-7.50", "-7.25", "-7.00", "-6.75", "-6.50", "-6.25", "-6.00", "-5.75", "-5.50", "-5.25", "-5.00", "-4.75", "-4.50", "-4.25", "-4.00", "-3.75", "-3.50", "-3.25", "-3.00", "-2.75", "-2.50", "-2.25", "-2.00", "-1.75", "-1.50", "-1.25", "-1.00", "-0.75", "-0.50", "-0.25", "0.00", "8.00", "7.75", "7.50", "7.25", "7.00", "6.75", "6.50", "6.25", "6.00", "5.75", "5.50", "5.25", "5.00", "4.75", "4.50", "4.25", "4.00", "3.75", "3.50", "3.25", "3.00", "2.75", "2.50", "2.25", "2.00", "1.75", "1.50", "1.25", "1.00", "0.75", "0.50", "0.25" }));
        LSPHJComboBox1.setMinimumSize(new java.awt.Dimension(50, 20));

        LCYLJComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-8.00", "-7.75", "-7.50", "-7.25", "-7.00", "-6.75", "-6.50", "-6.25", "-6.00", "-5.75", "-5.50", "-5.25", "-5.00", "-4.75", "-4.50", "-4.25", "-4.00", "-3.75", "-3.50", "-3.25", "-3.00", "-2.75", "-2.50", "-2.25", "-2.00", "-1.75", "-1.50", "-1.25", "-1.00", "-0.75", "-0.50", "-0.25", "0.00", "8.00", "7.75", "7.50", "7.25", "7.00", "6.75", "6.50", "6.25", "6.00", "5.75", "5.50", "5.25", "5.00", "4.75", "4.50", "4.25", "4.00", "3.75", "3.50", "3.25", "3.00", "2.75", "2.50", "2.25", "2.00", "1.75", "1.50", "1.25", "1.00", "0.75", "0.50", "0.25" }));
        LCYLJComboBox1.setMinimumSize(new java.awt.Dimension(50, 20));
        LCYLJComboBox1.setPreferredSize(new java.awt.Dimension(50, 20));
        LCYLJComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LCYLJComboBox1ActionPerformed(evt);
            }
        });

        LAxisComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122", "123", "124", "125", "126", "127", "128", "129", "130", "131", "132", "133", "134", "135", "136", "137", "138", "139", "140", "141", "142", "143", "144", "145", "146", "147", "148", "149", "150", "151", "152", "153", "154", "155", "156", "157", "158", "159", "160", "161", "162", "163", "164", "165", "166", "167", "168", "169", "170", "171", "172", "173", "174", "175", "176", "177", "178", "179", "180", "181", "182", "183", "184", "185", "186", "187", "188", "189", "190", "191", "192", "193", "194", "195", "196", "197", "198", "199", "200", "201", "202", "203", "204", "205", "206", "207", "208", "209", "210", "211", "212", "213", "214", "215", "216", "217", "218", "219", "220", "221", "222", "223", "224", "225", "226", "227", "228", "229", "230", "231", "232", "233", "234", "235", "236", "237", "238", "239", "240", "241", "242", "243", "244", "245", "246", "247", "248", "249", "250", "251", "252", "253", "254", "255", "256", "257", "258", "259", "260", "261", "262", "263", "264", "265", "266", "267", "268", "269", "270", "271", "272", "273", "274", "275", "276", "277", "278", "279", "280", "281", "282", "283", "284", "285", "286", "287", "288", "289", "290", "291", "292", "293", "294", "295", "296", "297", "298", "299", "300", "301", "302", "303", "304", "305", "306", "307", "308", "309", "310", "311", "312", "313", "314", "315", "316", "317", "318", "319", "320", "321", "322", "323", "324", "325", "326", "327", "328", "329", "330", "331", "332", "333", "334", "335", "336", "337", "338", "339", "340", "341", "342", "343", "344", "345", "346", "347", "348", "349", "350", "351", "352", "353", "354", "355", "356", "357", "358", "359", "360" }));
        LAxisComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LAxisComboBox1ActionPerformed(evt);
            }
        });

        LVDComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6/6", "6/9", "6/12", "6/18", "6/24", "6/36" }));
        LVDComboBox1.setPreferredSize(new java.awt.Dimension(50, 20));
        LVDComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LVDComboBox1ActionPerformed(evt);
            }
        });

        LNearAddComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+1.00", "+1.25", "+1.50", "+1.75", "+2.00", "+2.25", "+2.50", "+2.75", "+3.00" }));
        LNearAddComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LNearAddComboBox1ActionPerformed(evt);
            }
        });

        LVNComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N-6", "N-8", "N-10", "N-12", "N-18", "N-24", "N-36" }));
        LVNComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LVNComboBox1ActionPerformed(evt);
            }
        });

        VnLabel.setText("VN");

        LensTypeLabel.setText("Lens Type");

        LensTypejComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Glass", "PC", " " }));

        LensForLabel.setText("Lens For");

        LensForjComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Distance ", "Near", "Bifocal", "Progressive" }));

        LensPriceLabel.setText("Lens Price");

        jLabel1.setText("Frame Price");

        FrameTypeLabel.setText("Frame Type");

        PaidAmountLabel.setText("Paid Amount");

        TotalAmountLabel.setText("Total Amount");

        PendingAmountLabel.setText("Pending Amount");

        InsertButton.setText("Insert");
        InsertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertButtonActionPerformed(evt);
            }
        });

        pUpdateBtn.setText("Update");
        pUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pUpdateBtnActionPerformed(evt);
            }
        });

        PriscriptionClearButton.setText("Clear");

        pDeleteBtn.setText("Delete");
        pDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pDeleteBtnActionPerformed(evt);
            }
        });

        EyeDetailLabel.setText("Eye Details");

        javax.swing.GroupLayout AddNewPriscriptionPanelLayout = new javax.swing.GroupLayout(AddNewPriscriptionPanel);
        AddNewPriscriptionPanel.setLayout(AddNewPriscriptionPanelLayout);
        AddNewPriscriptionPanelLayout.setHorizontalGroup(
            AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                        .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                                .addComponent(EyeLabel)
                                .addGap(28, 28, 28)
                                .addComponent(SPHLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(CYLLABEL))
                            .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                                .addComponent(RightEyeLabel)
                                .addGap(18, 18, 18)
                                .addComponent(RSPHJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RCYLJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(AxisLabel))
                            .addComponent(RAxisComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RVDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(VDLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                                .addComponent(RNearAddComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RVNComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                                .addComponent(NearAddLabel)
                                .addGap(18, 18, 18)
                                .addComponent(VnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                        .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                                .addComponent(LeftEyeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LSPHJComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LCYLJComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(LAxisComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                                .addComponent(LensTypeLabel)
                                .addGap(18, 18, 18)
                                .addComponent(LensTypejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(FramePriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AddNewPriscriptionPanelLayout.createSequentialGroup()
                                    .addComponent(LensForLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LensForjComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AddNewPriscriptionPanelLayout.createSequentialGroup()
                                    .addComponent(LVDComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(LNearAddComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(LVNComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                        .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                                .addComponent(FrameTypeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(FrameTypeTF))
                            .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                                .addComponent(LensPriceLabel)
                                .addGap(18, 18, 18)
                                .addComponent(LensPriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(56, 56, 56)
                        .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PendingAmountLabel)
                            .addComponent(PaidAmountLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PaidAmountTF, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PendingAmountTF, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(TotalAmountLabel)
                        .addGap(10, 10, 10)
                        .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(InsertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TotalAmountTF, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PriscriptionClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pDeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(EyeDetailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 33, Short.MAX_VALUE))
        );
        AddNewPriscriptionPanelLayout.setVerticalGroup(
            AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(EyeDetailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                        .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EyeLabel)
                            .addComponent(SPHLabel)
                            .addComponent(CYLLABEL))
                        .addGap(1, 1, 1)
                        .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(RightEyeLabel))
                            .addComponent(RCYLJComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RSPHJComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                            .addComponent(AxisLabel)
                            .addGap(1, 1, 1)
                            .addComponent(RAxisComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                            .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(VDLabel)
                                .addComponent(NearAddLabel)
                                .addComponent(VnLabel))
                            .addGap(1, 1, 1)
                            .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(RVDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(RNearAddComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(RVNComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(6, 6, 6)
                .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(LeftEyeLabel))
                    .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LCYLJComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LSPHJComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(LAxisComboBox1)
                    .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LVDComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LNearAddComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LVNComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LensTypejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(LensTypeLabel))
                    .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LensForLabel)
                        .addComponent(LensForjComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(LensPriceLabel))
                            .addComponent(LensPriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FramePriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(AddNewPriscriptionPanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FrameTypeLabel)
                            .addComponent(FrameTypeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TotalAmountTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TotalAmountLabel)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddNewPriscriptionPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PaidAmountLabel)
                            .addComponent(PaidAmountTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PendingAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PendingAmountTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(AddNewPriscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InsertButton)
                    .addComponent(pUpdateBtn)
                    .addComponent(PriscriptionClearButton)
                    .addComponent(pDeleteBtn))
                .addGap(0, 59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AddNewPerscriptionPanelLayout = new javax.swing.GroupLayout(AddNewPerscriptionPanel);
        AddNewPerscriptionPanel.setLayout(AddNewPerscriptionPanelLayout);
        AddNewPerscriptionPanelLayout.setHorizontalGroup(
            AddNewPerscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddNewPerscriptionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CustomerIDLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(AddNewPerscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NoteVarLabel)
                    .addGroup(AddNewPerscriptionPanelLayout.createSequentialGroup()
                        .addComponent(PercriptonIDLabl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PrescriptionIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(126, 126, 126))
            .addGroup(AddNewPerscriptionPanelLayout.createSequentialGroup()
                .addComponent(AddNewPriscriptionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        AddNewPerscriptionPanelLayout.setVerticalGroup(
            AddNewPerscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddNewPerscriptionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AddNewPerscriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CustomerIDLabel)
                    .addComponent(PercriptonIDLabl)
                    .addComponent(PrescriptionIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(NoteVarLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddNewPriscriptionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Add New Perscription", AddNewPerscriptionPanel);

        CustomerRecordTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Contact", "Age", "Address", "Gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(CustomerRecordTable);

        PresTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "customer_id", "R_SPH", " L_SPH", "R_CYL", "L_CYL", "R_Axis", "L_Axis", "R_VD", "L_VD", "R_NearAdd", "L_NearAdd", "R_VN", "L_VN", "Lens_type", "Lens_for", "Lens_price", "Frame_price", "Frame_type", "Paid_Amount", "Total_Amount", "Pending_Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(PresTable);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void CustomerNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerNameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerNameTFActionPerformed

    private void ContactTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContactTFActionPerformed

    private void AgeTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgeTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AgeTFActionPerformed

    private void LVNComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LVNComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LVNComboBox1ActionPerformed

    private void LNearAddComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LNearAddComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LNearAddComboBox1ActionPerformed

    private void LVDComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LVDComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LVDComboBox1ActionPerformed

    private void LCYLJComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LCYLJComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LCYLJComboBox1ActionPerformed

    private void RVDComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RVDComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RVDComboBoxActionPerformed

    private void RCYLJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RCYLJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RCYLJComboBoxActionPerformed

    private void PrescriptionIDTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrescriptionIDTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrescriptionIDTFActionPerformed

    private void LAxisComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LAxisComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LAxisComboBox1ActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        // TODO add your handling code here:
                int a = CustomerRecordTable.getSelectedRow();
                
                Object id = model.getValueAt(a, 0);
                Object cusName = model.getValueAt(a, 1);
                Object cusCon = model.getValueAt(a, 2);
                Object age = model.getValueAt(a, 3);
                Object address = model.getValueAt(a, 4);
                Object gender = model.getValueAt(a, 5);
                
                CustomerNameTF.setText((String)cusName);
                ContactTF.setText((String)cusCon);
                AgeTF.setText(age.toString());
                AddressTF.setText((String)address);
                
                if(gender.equals("male")){
                    male.setSelected(true);
                }
                else{
                    female.setSelected(true);
                    
                }
                
                
                
                    
        
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
       int a = CustomerRecordTable.getSelectedRow();
       if(a<0){
           JOptionPane.showMessageDialog(null, "Please select the row first");
           return;
       }
       int id = (Integer)model.getValueAt(a, 0);
       connection.delete(id);
       model.removeRow(a);
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void InsertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertButtonActionPerformed
        // TODO add your handling code here:
        //PresDetails pres = new PresDetails();
        
    }//GEN-LAST:event_InsertButtonActionPerformed

    private void pUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pUpdateBtnActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_pUpdateBtnActionPerformed

    private void pDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pDeleteBtnActionPerformed
        // TODO add your handling code here:
          int a = PresTable.getSelectedRow();
                if(a<0){
                    JOptionPane.showMessageDialog(null, "First Select a table");
                    return;
                }
                int id = (Integer)model1.getValueAt(a, 0); 
                //connection.deletePres(id);
                model1.removeRow(a);
    }//GEN-LAST:event_pDeleteBtnActionPerformed

                                              
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddNewInfoPanel;
    private javax.swing.JPanel AddNewPerscriptionPanel;
    private javax.swing.JPanel AddNewPriscriptionPanel;
    private javax.swing.JLabel AddressLabel;
    private javax.swing.JTextField AddressTF;
    private javax.swing.JLabel AgeLabel;
    private javax.swing.JTextField AgeTF;
    private javax.swing.JLabel AxisLabel;
    private javax.swing.JTextField CIDTF;
    private javax.swing.JLabel CYLLABEL;
    //private javax.swing.JButton ClearButton;
    private javax.swing.JLabel ContactLabel;
    private javax.swing.JTextField ContactTF;
    private javax.swing.JLabel CustomerIDLabel;
    private javax.swing.JLabel CustomerNameLabel;
    private javax.swing.JTextField CustomerNameTF;
    private javax.swing.JTable CustomerRecordTable;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JLabel EyeDetailLabel;
    private javax.swing.JLabel EyeLabel;
    //private javax.swing.JTextField FramePriceTF;
    private javax.swing.JLabel FrameTypeLabel;
    private javax.swing.JTextField FrameTypeTF;
    private javax.swing.JLabel GenderLabel;
    //private javax.swing.JButton InsertButton;
    private javax.swing.JComboBox<String> LAxisComboBox1;
    private javax.swing.JComboBox<String> LCYLJComboBox1;
    private javax.swing.JComboBox<String> LNearAddComboBox1;
    private javax.swing.JComboBox<String> LSPHJComboBox1;
    private javax.swing.JComboBox<String> LVDComboBox1;
    private javax.swing.JComboBox<String> LVNComboBox1;
    private javax.swing.JLabel LeftEyeLabel;
    private javax.swing.JLabel LensForLabel;
    private javax.swing.JComboBox<String> LensForjComboBox1;
    private javax.swing.JLabel LensPriceLabel;
    //private javax.swing.JTextField LensPriceTF;
    private javax.swing.JLabel LensTypeLabel;
    private javax.swing.JComboBox<String> LensTypejComboBox;
    private javax.swing.JLabel NearAddLabel;
    private javax.swing.JLabel NoteVarLabel;
    private javax.swing.JLabel PaidAmountLabel;
    private javax.swing.JTextField PaidAmountTF;
    private javax.swing.JLabel PendingAmountLabel;
    private javax.swing.JTextField PendingAmountTF;
    private javax.swing.JLabel PercriptonIDLabl;
    private javax.swing.JTable PresTable;
    private javax.swing.JTextField PrescriptionIDTF;
    private javax.swing.JButton PriscriptionClearButton;
    private javax.swing.JComboBox<String> RAxisComboBox;
    private javax.swing.JComboBox<String> RCYLJComboBox;
    private javax.swing.JComboBox<String> RNearAddComboBox;
    private javax.swing.JComboBox<String> RSPHJComboBox;
    private javax.swing.JComboBox<String> RVDComboBox;
    private javax.swing.JComboBox<String> RVNComboBox;
    private javax.swing.JLabel RightEyeLabel;
    private javax.swing.JLabel SPHLabel;
    //private javax.swing.JButton SaveButton;
    private javax.swing.JLabel TotalAmountLabel;
    private javax.swing.JTextField TotalAmountTF;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel VDLabel;
    private javax.swing.JLabel VnLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton female;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JRadioButton male;
    private javax.swing.JButton pDeleteBtn;
    private javax.swing.JButton pUpdateBtn;
    // End of variables declaration//GEN-END:variables
}
