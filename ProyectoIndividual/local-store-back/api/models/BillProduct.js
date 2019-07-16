/**
 * BillProduct.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    quantity : {
      type : 'number',
      min : 0
    },
    bill_FK : {
      model : 'bill'
    },
    product_FK : {
      model : 'product'
    }
    
  },

};

