package view

import com.example.demo.app.Bill
import com.example.demo.app.Client
import com.example.demo.app.Employee
import com.example.demo.app.Product
import com.example.demo.controller.*
import java.awt.Dimension
import java.awt.Font
import javax.swing.*
import javax.swing.table.DefaultTableModel

class ClassView (val name: String){

    val frame = JFrame(name)
    val pane = JPanel()
    private val spanel: JScrollPane? = JScrollPane()
    var table: JTable? = JTable()
    val searchField = JTextField(16)
    val searchButton = JButton("Buscar")
    val insertButton = JButton("Ingresar")
    val updateButton = JButton("Editar")
    val deleteButton = JButton("Eliminar")
    var objects : ArrayList<*>? = null
    var model : DefaultTableModel = DefaultTableModel()

    init{
        createView()
    }

    fun main(){
        when(name){
            "Productos" ->{
                objects = ProductController().select()
                updateProductsTable()
                insertButton.addActionListener {
                    InsertProductView()
                }
                updateButton.addActionListener {
                    UpdateProductView()
                }
                searchButton.addActionListener {
                    if(searchField.text == "") {
                        objects = ProductController().select()
                    }else{
                        objects = ArrayList<Product>()
                        (objects as ArrayList<Product>).add(ProductController().select(searchField.text))
                        searchField.text = ""
                    }
                    updateProductsTable()
                }
                deleteButton.addActionListener {
                    removeProducts()
                    objects = ProductController().select()
                }
            }
            "Clientes" -> {
                objects = ClientController().select()
                updateClientsTable()
                insertButton.addActionListener {
                    InsertClientView()
                }
                searchButton.addActionListener {
                    if(searchField.text == "") {
                        objects = ClientController().select()
                    }else{
                        objects = ArrayList<Client>()
                        (objects as ArrayList<Client>).add(ClientController().select(searchField.text))
                        searchField.text = ""
                    }
                    updateClientsTable()
                }
                deleteButton.addActionListener {
                    removeClients()
                    objects = ClientController().select()
                }
                updateButton.addActionListener {
                    UpdateClientView()
                }
            }
            "Empleados" -> {
                objects = EmployeeController().select()
                updateEmployeesTable()
            }
            "Facturacion" -> {
                objects = BillController().select()
                updateBillsTable()
                updateButton.isVisible = false
                insertButton.addActionListener{
                    InsertBillView()
                }
                searchButton.addActionListener {
                    if(searchField.text == "") {
                        objects = BillController().select()
                    }else{
                        objects = ArrayList<Bill>()
                        (objects as ArrayList<Bill>).add(BillController().select(searchField.text.toInt()))
                        searchField.text = ""
                    }
                    updateBillsTable()
                }
                deleteButton.addActionListener {
                    removeBills()
                    objects = BillController().select()
                }
            }
        }
    }

    fun updateProductsTable(){
        val columName = (objects as ArrayList<Product>)[0].propertiesNames()
        var data: Array<Array<Any>> = arrayOf()
        (objects as ArrayList<Product>).forEach {
            val rowData : Array<Any> = arrayOf(1,2,3,4,5)
            rowData[0] = it.id
            rowData[1] = it.type
            rowData[2] = it.name
            rowData[3] = it.description
            rowData[4] = it.price
            data += rowData
        }
        model = DefaultTableModel(data,columName)
        table = JTable(model)
        spanel!!.viewport.add(table)
    }

    fun updateClientsTable(){
        val columnName = (objects as ArrayList<Client>)[0].propertiesNames()
        var data: Array<Array<Any>> = arrayOf()
        (objects as ArrayList<Client>).forEach {
            val rowData : Array<Any> = arrayOf(1,2,3,4,5,6,7)
            rowData[0] = it.id
            rowData[1] = it.firstName
            rowData[2] = it.lastName
            rowData[3] = it.gender
            rowData[4] = it.age
            rowData[5] = it.phoneNumber
            rowData[6] = it.address
            data += rowData
        }
        model = DefaultTableModel(data,columnName)
        table = JTable(model)
        spanel!!.viewport.add(table)
    }

    fun updateBillsTable(){
        val columnName = (objects as ArrayList<Bill>)[0].propertiesNames()
        var data: Array<Array<Any>> = arrayOf()
        (objects as ArrayList<Bill>).forEach {
            val rowData : Array<Any> = arrayOf(1,2,3,4,5,6)
            rowData[0] = it.id
            rowData[1] = it.storeId
            rowData[2] = it.employeeId
            rowData[3] = it.clientId
            var products = ""
            it.products.forEach{
                products = "${it.name}, $products"
            }
            rowData[4] = products
            rowData[5] = it.totalPrice
            data += rowData
        }
        model = DefaultTableModel(data,columnName)
        table = JTable(model)
        spanel!!.viewport.add(table)
    }

    fun updateEmployeesTable(){
        val columnName = (objects as ArrayList<Employee>)[0].propertiesNames()
        var data: Array<Array<Any>> = arrayOf()
        (objects as ArrayList<Employee>).forEach {
            val rowData : Array<Any> = arrayOf(1,2,3,4,5,6,7,8,9,10)
            rowData[0] = it.id
            rowData[1] = it.firstName
            rowData[2] = it.lastName
            rowData[3] = it.gender
            rowData[4] = it.age
            rowData[5] = it.phoneNumber
            rowData[6] = it.address
            rowData[7] = it.charge
            if(it.reportsTo != null)
                rowData[8] = it.reportsTo!!.id
            else
                rowData[8] = ""
            rowData[9] = it.bankAccount
            data += rowData
        }
        model = DefaultTableModel(data,columnName)
        table = JTable(model)
        spanel!!.viewport.add(table)
    }

    fun removeBills() {
        val numRows = table!!.selectedRows.size

        for (i in 0 until numRows) {
            BillController().delete(table!!.getValueAt(table!!.selectedRow,0).toString().toInt())
            model.removeRow(table!!.selectedRow)

        }
    }

    fun removeProducts(){
        val numRows = table!!.selectedRows.size

        for (i in 0 until numRows) {
            ProductController().delete(table!!.getValueAt(table!!.selectedRow,0).toString())
            model.removeRow(table!!.selectedRow)

        }
    }

    fun removeClients(){
        val numRows = table!!.selectedRows.size

        for (i in 0 until numRows) {
            ClientController().delete(table!!.getValueAt(table!!.selectedRow,0).toString())
            model.removeRow(table!!.selectedRow)

        }
    }

    fun createView(){
        frame.contentPane = pane
        frame.defaultCloseOperation = JFrame.DISPOSE_ON_CLOSE
        frame.setSize(600,400)

        var ly = GroupLayout(frame.contentPane)
        frame.contentPane.setLayout(ly)

        spanel!!.add(table)

        ly.autoCreateGaps = true
        ly.autoCreateContainerGaps = true

        ly.setVerticalGroup(ly.createSequentialGroup()
                .addGroup(ly.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(searchField)
                        .addComponent(searchButton)
                )
                .addComponent(spanel)
                .addGroup(ly.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(insertButton)
                        .addComponent(updateButton)
                        .addComponent(deleteButton)
                )
        )

        ly.setHorizontalGroup(ly.createSequentialGroup()
                .addGroup(ly.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(ly.createSequentialGroup()
                                .addGroup(ly.createParallelGroup(GroupLayout.Alignment.LEADING))
                                .addComponent(searchField)
                                .addComponent(searchButton)
                        )
                        .addComponent(spanel)
                        .addGroup(ly.createSequentialGroup()
                                .addGroup(ly.createParallelGroup(GroupLayout.Alignment.LEADING))
                                .addComponent(insertButton)
                                .addComponent(updateButton)
                                .addComponent(deleteButton)

                        )
                )
        )

        frame.setLocationRelativeTo(null)
        frame.isVisible = true
    }
}