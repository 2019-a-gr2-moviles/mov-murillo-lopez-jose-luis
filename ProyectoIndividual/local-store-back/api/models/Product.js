/**
 * Product.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    name : {
      type : 'string',
      required : true,
      minLength : 3,
      maxLength : 32
    },
    type : {
      type : 'string',
    },
    description : {
      type : 'string'
    },
    price : {
      type : 'number',
      min : 0
    },
    bills : {
      collection : 'billProduct',
      via : 'product_FK'
    },
    productPicFD : {
      type : 'string'
    }

  },

};

