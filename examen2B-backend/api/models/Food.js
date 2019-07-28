/**
 * Food.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    foodName : {
      type: 'string'
    },
    foodDescription : {
      type : 'string'
    },
    nacionality : {
      type : 'string'
    },
    numberPeople : {
      type : 'number'
    },
    hotSpicy : {
      type : 'boolean'
    },
    ingredients : {
      collection : 'Ingredient',
      via : 'food_FK'
    }

  },

};

