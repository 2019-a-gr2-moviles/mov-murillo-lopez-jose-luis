package com.example.demo.view

import com.example.demo.app.Branch
import com.example.demo.app.Client
import com.example.demo.app.Product
import com.example.demo.app.Styles
import com.example.demo.controller.BillController
import com.example.demo.controller.ClientController
import com.example.demo.controller.EmployeeController
import com.example.demo.controller.ProductController
import javafx.scene.layout.AnchorPane
import tornadofx.*
import tornadofx.column
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.input.MouseEvent
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.scene.Parent
import javafx.fxml.FXMLLoader




class MainView : View("Hello TornadoFX") {

    val store = Branch(1,"Emprovit","Olmedo y Sucre","Ambato")

    init{
        store.bills = BillController().select()
        store.employees = EmployeeController().select()
        store.products = ProductController().select()
    }

    val clients : ArrayList<Client> = ClientController().select()

    @FXML
    private val productButton: Button? = null

    @FXML
    private val clientButton: Button? = null

    @FXML
    private val employeeButton: Button? = null

    @FXML
    private val billButton: Button? = null

    @FXML
    fun BillMouseClicked(event: MouseEvent) {
        try {
            val fxmlLoader = FXMLLoader(javaClass.getResource("ClassView.fxml"))
            val root1 = fxmlLoader.load<Any>() as Parent
            val stage = Stage()
            stage.title = "Facturas"
            stage.scene = Scene(root1)
            stage.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @FXML
    fun ClientMouseClicked(event: MouseEvent) {
        try {
            val fxmlLoader = FXMLLoader(javaClass.getResource("ClassView.fxml"))
            val root1 = fxmlLoader.load<Any>() as Parent
            val stage = Stage()
            stage.title = "Clientes"
            stage.scene = Scene(root1)
            stage.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @FXML
    fun EmployeeMouseClicked(event: MouseEvent) {
        try {
            val fxmlLoader = FXMLLoader(javaClass.getResource("ClassView.fxml"))
            val root1 = fxmlLoader.load<Any>() as Parent
            val stage = Stage()
            stage.title = "Empleados"
            stage.scene = Scene(root1)
            stage.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @FXML
    fun ProductMouseClicked(event: MouseEvent) {
        try {
            val fxmlLoader = FXMLLoader(javaClass.getResource("ClassView.fxml"))
            val root1 = fxmlLoader.load<Any>() as Parent
            val stage = Stage()
            stage.title = "Productos"
            stage.scene = Scene(root1)
            stage.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }


    }

    override val root : AnchorPane by fxml()

}