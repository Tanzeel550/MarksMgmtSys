//package sample.Model;
//
//import sample.Students;
//
//import java.util.ArrayList;
//
//public class LaterUse {
//
//    ArrayList<String> namesList = new ArrayList<>();
//    ArrayList<Integer> englishMarksList = new ArrayList<>();
//    ArrayList<Integer> urduMarksList = new ArrayList<>();
//    ArrayList<Integer> bioMarksList = new ArrayList<>();
//    ArrayList<Integer> chemMarksList = new ArrayList<>();
//    ArrayList<Integer> physicsMarksList = new ArrayList<>();
//    ArrayList<Integer> islamiatMarksList = new ArrayList<>();
//
//    private final Students instance = new Students();
//
//    public Students getInstance() {
//        return instance;
//    }
//
//    public boolean add(String name, int enlish, int urdu, int bio, int chem, int physics, int islamiat) {
//
//        for (String n: namesList)
//            if (n.equals(name))
//                return false;
//
//        namesList.add(name);
//        englishMarksList.add(enlish);
//        urduMarksList.add(urdu);
//        bioMarksList.add(bio);
//        chemMarksList.add(chem);
//        physicsMarksList.add(physics);
//        islamiatMarksList.add(islamiat);
//
//        return true;
//    }
//
//
//
//
//    //    <TableView GridPane.rowIndex="0" GridPane.columnIndex="0" fx:id="tableview" prefWidth="1200" prefHeight="850"/>
////
////    <FlowPane orientation="VERTICAL" GridPane.rowIndex="0" GridPane.columnIndex="1">
////        <Label text="This project is for the students of Nps. So if someone wants to use this project, he must be admitted in NPS" />
////
////        <GridPane>
////            <Label text="Name: " GridPane.rowIndex="0" GridPane.columnIndex="0" alignment="TOP_LEFT" />
////            <TextField GridPane.rowIndex="0" GridPane.columnIndex="1" alignment="TOP_LEFT"/>
////            <Label text="English: " GridPane.rowIndex="0" GridPane.columnIndex="2" alignment="TOP_LEFT"/>
////            <TextField GridPane.rowIndex="0" GridPane.columnIndex="3" alignment="TOP_LEFT"/>
////
////            <Label text="Urdu: " GridPane.rowIndex="1" GridPane.columnIndex="0"/>
////            <TextField GridPane.rowIndex="1" GridPane.columnIndex="1"/>
////            <Label text="Physics: " GridPane.rowIndex="1" GridPane.columnIndex="2"/>
////            <TextField GridPane.rowIndex="1" GridPane.columnIndex="3"/>
////
////            <Label text="Chemistry: " GridPane.rowIndex="2" GridPane.columnIndex="0"/>
////            <TextField GridPane.rowIndex="2" GridPane.columnIndex="1"/>
////            <Label text="Biology: " GridPane.rowIndex="2" GridPane.columnIndex="2"/>
////            <TextField GridPane.rowIndex="2" GridPane.columnIndex="3"/>
////
////            <Label text="Islamiat: " GridPane.rowIndex="3" GridPane.columnIndex="0"/>
////            <TextField GridPane.rowIndex="3" GridPane.columnIndex="1"/>
////            <Label text="Total: " GridPane.rowIndex="3" GridPane.columnIndex="2"/>
////            <TextField GridPane.rowIndex="3" GridPane.columnIndex="3"/>
////
////        </GridPane>
////
////    </FlowPane>
////
//
//
//
//}
