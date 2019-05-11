package view

import com.example.demo.controller.ClientController
import com.example.demo.controller.ProductController
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Insets
import javax.swing.*

class UpdateClientView {

    val frame = JFrame("Editar cliente")
    val pane = JPanel()
    val idPane = JLabel("Característica a modificar")
    val idLabel = JLabel("ID del cliente")
    val options = JComboBox(arrayOf("Número de teléfono","Dirección"))
    val idText = JTextField(20)
    val newValueText = JTextField(20)
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
            var toModify = ""
            when(options.selectedItem.toString()){
                "Número de teléfono" -> toModify = "phoneNumber"
                "Dirección" -> toModify = "address"
            }
            ClientController().update(idText.text,toModify,newValueText.text)
        }

        val gbc = GridBagConstraints()

        gbc.insets = Insets(5,5,5,5)

        frame.contentPane.layout = GridBagLayout()

        gbc.fill = GridBagConstraints.HORIZONTAL
        gbc.gridx = 0
        gbc.gridy = 0
        frame.add(idLabel,gbc)
        gbc.gridx = 1
        gbc.gridy = 0
        frame.add(idText,gbc)
        gbc.gridx = 0
        gbc.gridy = 1
        frame.add(idPane,gbc)
        gbc.gridx = 0
        gbc.gridy = 2
        frame.add(options,gbc)
        gbc.gridx = 1
        gbc.gridy = 2
        frame.add(newValueText,gbc)
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