/**
 * Client.js
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
    lastName : {
      type : 'string',
      required : true,
      minLength : 3,
      maxLength : 32
    },
    gender : {
      type : 'string'
    },
    phone : {
      type : 'string'
    },
    user_person_FK : {
      model : 'user'
    },
    bills : {
      collection : 'bill',
      via : 'client_bill_FK'
    }

  },

};

