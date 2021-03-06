/**
 * Usuario.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    nombre: {
      type : 'string',
      required : true,
      minLength : 3,
      maxLength : 60
    },
    cedula : {
      type : 'string',
      required : true,
      unique : true,
      minLength : 10,
      maxLength : 25
    },
    username : {
      type : 'string',
      required : true,
      unique : true
    },
    fechaNacimiento : {
      type : 'string'
    },
    sueldo : {
      type : 'number',
      min : 100.0,
      max : 5000,
      defaultsTo : 100.0
    },
    estaCasado : {
      type : 'boolean',
      defaultsTo : false
    },
    longitudCasa : {
      type : 'string',
    },
    latitudCasa : {
      type : 'string'
    },
    tipoUsuario : {
      type : 'string',
      enum : ['normal','pendiente','premium']
    },
    correo : {
      type : 'string',
      isEmail : true
    },
    serviciosDeUsuario : {
      collection : 'servicio',
      via : 'fkUsuario'
    },
    fkEmpresa : {
      model : 'empresa'
    }

  }

};

