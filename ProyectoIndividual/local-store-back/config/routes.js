/**
 * Route Mappings
 * (sails.config.routes)
 *
 * Your routes tell Sails what to do each time it receives a request.
 *
 * For more information on configuring custom routes, check out:
 * https://sailsjs.com/anatomy/config/routes-js
 */

module.exports.routes = {

  /***************************************************************************
  *                                                                          *
  * Make the view located at `views/homepage.ejs` your home page.            *
  *                                                                          *
  * (Alternatively, remove this and add an `index.html` file in your         *
  * `assets` directory)                                                      *
  *                                                                          *
  ***************************************************************************/

  '/': { view: 'pages/homepage' },
  'POST /picture' : {
    action : 'product/upload'
  },
  'GET /picture' : {
    action : 'product/getPic'
  },
  'POST /login' : {
    action : 'user/login'
  },
  'GET /allBills' : {
    action : 'bill/listBills'
  },
  'GET /retrieveClient' : {
    action : 'client/getClient'
  }

};
