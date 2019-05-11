package view

import com.example.demo.controller.BillController
import com.example.demo.controller.BillDetail
import com.example.demo.controller.ClientController
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Insets
import javax.swing.*

class InsertClientView {

    val frame = JFrame("Nuevo cliente")
    val pane = JPanel()
    val idPane = JLabel("ID del cliente")
    val storeIdPane = JLabel("Nombres")
    val employeeIdPane = JLabel("Apellidos")
    val clientIdPane = JLabel("Genero")
    val productsPane = JLabel("Edad")
    val phonePane = JLabel("Número de teléfono")
    val addressPane = JLabel("Dirección")
    val idText = JTextField(20)
    val storeIdText = JTextField(20)
    val employeeIdText = JTextField(20)
    val clientIdText = JTextField(20)
    val productsText = JTextField(20)
    val phoneText = JTextField(20)
    val addressText = JTextField(20)
    val cancellButton = JButton("Cancelar")
    val insertButton = JButton("Guardar")


    init {
        frame.setSize(400, 300)
        frame.defaultCloseOperation = JFrame.DISPOSE_ON_CLOSE
        frame.contentPane = pane

        cancellButton.addActionListener {
            frame.dispose()
        }

        insertButton.addActionListener {
            ClientController().insert(idText.text, storeIdText.text, employeeIdText.text, clientIdText.text, productsText.text.toInt(), phoneText.text, addressText.text)
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
        frame.add(phonePane,gbc)
        gbc.gridx = 1
        gbc.gridy = 5
        frame.add(phoneText,gbc)
        gbc.gridx = 0
        gbc.gridy = 6
        frame.add(addressPane,gbc)
        gbc.gridx = 1
        gbc.gridy = 6
        frame.add(addressText,gbc)
        gbc.gridx = 0
        gbc.gridy = 7
        frame.add(cancellButton,gbc)
        gbc.gridx = 1
        gbc.gridy = 7
        frame.add(insertButton,gbc)

        frame.setLocationRelativeTo(null)
        frame.isVisible = true
    }
}