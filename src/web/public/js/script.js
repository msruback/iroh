window.onload = function(){
	window.iroh = new Iroh();
}
function Iroh(){
	this.initFirebase();
	this.signInButton = document.getElementById('sign-in')
	this.signInButton.addEventListener('click', this.signIn())
}
Iroh.initFirebase = function(){
	this.auth = firebase.auth();
	this.database() = firebase.database();
	this.storage()= firebase.storage();
	
	this.auth.onAuthStateChanged(this.onAuthStateChanged.bind(this);
}
Iroh.signIn = function(){
	var provider = new firebase.auth.GoogleAuthProvider();
	this.auth.signInWithPopup(provider)
}
Iroh.signout = function(){
	this.auth.signOut()
}