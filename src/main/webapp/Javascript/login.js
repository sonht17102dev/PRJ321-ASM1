function validateFormSubmit(){
    let user = document["login-form"]["username"].value;
    let pwd = document["login-form"]["password"].value;
	
    let s = "";
    if (user=="") {
        s += "Username must be filled in";
    }
    if (pwd=="") {
        if (s=="")
        	s += "Password must be filled in";
        else 
        	s +="\nPassword must be filled in";
    }

    if (s=="") {
		
		return true;
    }else {
       
        return confirm(s);
    }
}