package com.example.demo.view

import com.example.demo.controller.ProductController
import javafx.scene.layout.AnchorPane
import tornadofx.*
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.scene.input.MouseEvent


class InsertProduct : View() {
    @FXML
    private val insertButton: Button? = null

    @FXML
    private val id: TextField? = null

    @FXML
    private val type: TextField? = null

    @FXML
    private val name: TextField? = null

    @FXML
    private val description: TextField? = null

    @FXML
    private val price: TextField? = null

    @FXML
    fun InsertButtonClicked(event: MouseEvent) {
        ProductController().insert(id!!.text.toInt(),type!!.text,name!!.text,description!!.text,price!!.text.toFloat())
    }

    override val root: AnchorPane by fxml()
}
