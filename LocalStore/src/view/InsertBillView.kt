package view

import com.example.demo.controller.BillController
import com.example.demo.controller.BillDetail
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Insets
import javax.swing.*

class InsertBillView {

    val frame = JFrame("Nueva factura")
    val pane = JPanel()
    val idPane = JLabel("ID de la factura")
    val storeIdPane = JLabel("ID de la tienda")
    val employeeIdPane = JLabel("ID del empleado")
    val clientIdPane = JLabel("ID del cliente")
    val productsPane = JLabel("Productos")
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
            var bd = BillDetail()
            val products = productsText.text.split(",")
            val detailId= bd.select().last().split(",")
            val productsID = detailId[0].toInt() + 1
            products.forEach {
                bd.insert(productsID,it.toInt())
            }
            BillController().insert(idText.text.toInt(),storeIdText.text.toInt(),employeeIdText.text,clientIdText.text,productsID,0.0f)
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
