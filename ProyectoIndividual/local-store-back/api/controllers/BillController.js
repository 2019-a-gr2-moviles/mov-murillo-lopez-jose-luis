/**
 * BillController
 *
 * @description :: Server-side actions for handling incoming requests.
 * @help        :: See https://sailsjs.com/docs/concepts/actions
 */

module.exports = {
  

    listBills : async (req, res) => {
        try{
            console.log(req.param('id'))
            var bill = await Bill.find({client_bill_FK : req.param('id')}).populate('products')
            var response = []
            Object.entries(bill).forEach(element => { 
                productsList = []
                Object.entries(element[1].products).forEach(async (element) => {
                    console.log(element)
                    var product = await Product.findOne(element[1].product_FK)
                    productsList.push(product)
                });
                var responseAux = {
                    "id" : element[1].id,
                    "date" : element[1].date,
                    "totalCost" : element[1].totalCost,
                    "products" : productsList
                }
                response.push(responseAux)
            })
            setTimeout(function(){
                return res.ok(response)
            }, 2000)
        }catch(e){
            return res.serverError()
        }
    }

};

