'use strict';

const functions = require('firebase-functions');

const admin = require('firebase-admin');
admin.initializeApp(functions.config());

exports.setUpUser = functions.auth.user().onCreate((user) => {
	var email = user.email;
	var uid = user.uid;
	
	const docRef = admin.firestore().doc('users/'+uid);
	
	return docRef.set({
		email : email
	});
});

exports.removeUser = functions.auth.user().onDelete((user) => {
	var uid = user.uid;
	const docRef = admin.firestore().doc('users/'+uid);
	
	return docRef.delete();
}

//exports.addTea = functions.https.onCall((data, context) => ){
//	var uid = context.auth.uid
//	var teaname = data.name
// var teatype = data.type
// var teatime = data.time
// var teatemp = data.temp
//}