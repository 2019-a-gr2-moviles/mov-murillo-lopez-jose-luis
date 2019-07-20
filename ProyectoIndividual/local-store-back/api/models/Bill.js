/**
 * Bill.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    date : {
      type : 'string'
    },
    totalCost : {
      type : 'number',
      min : 0
    },
    products : {
      collection : 'billProduct',
      via : 'bill_FK'
    },
    client_bill_FK : {
      model : 'client'
    }

  },

};

