/*
 * File: app/view/MyWindowImage.js
 *
 * This file was generated by Sencha Architect version 2.1.0.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 4.1.x library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 4.1.x. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('MyApp.view.MyWindowImage', {
	extend: 'Ext.window.Window',

	height: 416,
	width: 749,
	constrain: true,
	layout: {
		type: 'border'
	},
	modal: true,
	maximizable: true,
	title: 'Rendimiento Anual',

	initComponent: function() {
		var me = this;

		Ext.applyIf(me, {
			items: [{
				xtype: 'panel',
				region: 'center',
				layout: {
					type: 'border'
				},
				collapsed: false,
				collapsible: true,

				items: [
				{
					 xtype: 'image',
                    region: 'center',
                    src: 'images/logo.png'
				}

				]
			}] });

		me.callParent(arguments);
	}

});