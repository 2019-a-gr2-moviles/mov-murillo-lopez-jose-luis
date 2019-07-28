/**
 * Ingredient.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    ingredientName : {
      type : 'string'
    },
    quantity : {
      type : 'number'
    },
    prepDescription : {
      type : 'string'
    },
    optional : {
      type : 'boolean'
    },
    ingredientType : {
      type : 'string'
    },
    coolNeeded : {
      type : 'boolean'
    },
    latitude : {
      type : 'string'
    },
    longitude : {
      type : 'string'
    },
    food_FK : {
      model : 'Food'
    }

  },

};

