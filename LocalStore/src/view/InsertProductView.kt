package view

import com.example.demo.app.Product
import com.example.demo.controller.BillController
import com.example.demo.controller.BillDetail
import com.example.demo.controller.ProductController
import java.awt.Dimension
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Insets
import java.util.ArrayList
import javax.swing.*

class InsertProductView {

    val frame = JFrame("Nuevo producto")
    val pane = JPanel()
    val idPane = JLabel("ID del producto")
    val storeIdPane = JLabel("Tipo")
    val employeeIdPane = JLabel("Nombre")
    val clientIdPane = JLabel("Descripción")
    val productsPane = JLabel("Precio")
    val idText = JTextField(20)
    val storeIdText = JTextField(20)
    val employeeIdText = JTextField(20)
    val clientIdText = JTextField(20)
    val productsText = JTextField(20)
    val cancellButton = JButton("Cancelar")
    val insertButton = JButton("Guardar")


    init{
        frame.setSize(400,300)
        frame.defaultCloseOperation = JFrame.DISPOSE_ON_CLOSE
        frame.contentPane = pane

        cancellButton.addActionListener{
            frame.dispose()
        }

        insertButton.addActionListener{
            ProductController().insert(idText.text.toInt(),storeIdText.text,employeeIdText.text,clientIdText.text,productsText.text.toFloat())
        }

        val gbc = GridBagConstraints()

        gbc.insets = Insets(5,5,5,5)

        frame.contentPane.layout = GridBagLayout()

        gbc.fill = GridBagConstraints.HORIZONTAL
        gbc.gridx = 0
        gbc.gridy = 0
        frame.add(idPane,gbc)
        gbc.gridx = 1
        gbc.gridy = 0
        frame.add(idText,gbc)
        gbc.gridx = 0
        gbc.gridy = 1
        frame.add(storeIdPane,gbc)
        gbc.gridx = 1
        gbc.gridy = 1
        frame.add(storeIdText,gbc)
        gbc.gridx = 0
        gbc.gridy = 2
        frame.add(employeeIdPane,gbc)
        gbc.gridx = 1
        gbc.gridy = 2
        frame.add(employeeIdText,gbc)
        gbc.gridx = 0
        gbc.gridy = 3
        frame.add(clientIdPane,gbc)
        gbc.gridx = 1
        gbc.gridy = 3
        frame.add(clientIdText,gbc)
        gbc.gridx = 0
        gbc.gridy = 4
        frame.add(productsPane,gbc)
        gbc.gridx = 1
        gbc.gridy = 4
        frame.add(productsText,gbc)
        gbc.gridx = 0
        gbc.gridy = 5
        frame.add(cancellButton,gbc)
        gbc.gridx = 1
        gbc.gridy = 5
        frame.add(insertButton,gbc)

        frame.setLocationRelativeTo(null)
        frame.isVisible = true
    }

}