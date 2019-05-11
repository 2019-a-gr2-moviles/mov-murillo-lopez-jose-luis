package view

import java.awt.Dimension
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Insets
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel

class MainView {

    val frame = JFrame("Tienda")
    val pane = JPanel()
    val productsButton = JButton("Productos")
    val customersButton = JButton("Clientes")
    val employeesButton = JButton("Empleados")
    val billsButton = JButton("Facturación")


    init{
        frame.setSize(300,200)
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.contentPane = pane

        productsButton.preferredSize = Dimension(300,200)
        productsButton.addActionListener {
            ClassView("Productos").main()
        }
        customersButton.preferredSize = Dimension(300,200)
        customersButton.addActionListener{
            ClassView("Clientes").main()
        }
        employeesButton.preferredSize = Dimension(300,200)
        employeesButton.addActionListener{
            ClassView("Empleados").main()
        }
        billsButton.preferredSize = Dimension(300,200)
        billsButton.addActionListener{
            ClassView("Facturacion").main()
        }

        //Secret module
        employeesButton.isVisible = false

        val gbc = GridBagConstraints()

        frame.contentPane.layout = GridBagLayout()

        gbc.insets = Insets(20,20,20,20)

        gbc.fill = GridBagConstraints.HORIZONTAL
        gbc.gridx = 0
        gbc.gridy = 0
        frame.add(productsButton,gbc)
        gbc.gridx = 1
        gbc.gridy = 0
        frame.add(customersButton,gbc)
        gbc.gridx = 0
        gbc.gridy = 1
        frame.add(employeesButton,gbc)
        gbc.gridx = 1
        gbc.gridy = 1
        frame.add(billsButton,gbc)

        frame.setLocationRelativeTo(null)
        frame.isVisible = true
    }

}