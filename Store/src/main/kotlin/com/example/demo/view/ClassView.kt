package com.example.demo.view

import com.example.demo.app.Product
import javafx.collections.FXCollections
import javafx.scene.Parent
import javafx.scene.layout.AnchorPane
import tornadofx.*
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.TableView
import javafx.scene.input.MouseEvent
import javafx.stage.Stage


class ClassView : View() {


    @FXML
    private val seacrhButton: Button? = null

    @FXML
    private val updateButton: Button? = null

    @FXML
    private val tableObject: TableView<*>? = null

    @FXML
    private val insertButton: Button? = null

    @FXML
    private val editButton: Button? = null

    @FXML
    private val deleteButton: Button? = null
//
//    @FXML
//    fun insertButtonClick(event: MouseEvent) {
//        try {
//            val fxmlLoader = FXMLLoader(javaClass.getResource("InsertProduct.fxml"))
//            val root1 = fxmlLoader.load<Any>() as Parent
//            val stage = Stage()
//            stage.title = "Insertar Producto"
//            stage.scene = Scene(root1)
//            stage.show()
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//
//    }

//    @FXML
//    fun UpdateTable(event: MouseEvent) {
//        println("hdjdj")
//
//        var products = FXCollections.observableArrayList(MainView().store.products)
//
//        tableObject!!.tableview(products) {
//            column("Id", Product::id)
//            column("Type", Product::type)
//            column("Name", Product::name)
//            column("Description", Product::description)
//            column("Price", Product::price)
//        }
//        println("hdjdj")
//    }

    override val root : AnchorPane by fxml{

    }



}