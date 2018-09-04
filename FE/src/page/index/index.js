/*
 * @Author: Renzi Meng
 * @Date: 2018-09-02 16:45:31
 * @Last Modified by: Renzi Meng
 * @Last Modified time: 2018-09-04 19:15:48
 */

'use strict';
require('./index.css');
require('page/common/nav/index.js');
require('page/common/header/index.js');
require('page/common/nav-side/index.js');
var navSide = require('page/common/nav-side/index.js');
var _mm = require('util/mm.js');

navSide.init({
  name: 'order-list'
});