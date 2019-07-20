/**
 * ClientController
 *
 * @description :: Server-side actions for handling incoming requests.
 * @help        :: See https://sailsjs.com/docs/concepts/actions
 */

module.exports = {

    getClient : async (req, res) => {
        try{
            var client = await Client.findOne(req.param('id')).populate('bills')
            var bills = []
            var aux = 0
            var products = []
            Object.entries(client.bills).forEach( async(element) => {
                products = []
                var bill = await Bill.findOne(element[1].id).populate('products')
                Object.entries(bill.products).forEach( async(element) => {
                    var product = await Product.findOne(element[1].product_FK)
                    products.push(product)
                })
                bills.push(
                    {
                        "id" : bill.id,
                        "date" : bill.date,
                        "totalCost" : bill.totalCost,
                        "products" : products
                    }
                )
            })
            setTimeout(function(){
                return res.ok({
                    "id" : client.id,
                    "name" : client.name,
                    "lastName" : client.lastName,
                    "gender" : client.lastName,
                    "phone" : client.phone,
                    "bills" : bills
                })
            }, 2000)
            
        }catch{
            return res.serverError()
        }
    }
  

};

