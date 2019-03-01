'use strict';

const functions = require('firebase-functions');

const admin = require('firebase-admin');
admin.initializeApp(functions.config());

exports.setUpUser = functions.auth.user().onCreate((user) => {
	var email = user.email;
	var uid = user.uid;
	
	const docRef = admin.firestore().doc('users/'+uid);
	
	return docRef.set({
		email : email,
		isAdmin : false
	});
});

exports.removeUser = functions.auth.user().onDelete((user) => {
	var uid = user.uid;
	const docRef = admin.firestore().doc('users/'+uid);
	
	return docRef.delete();
});