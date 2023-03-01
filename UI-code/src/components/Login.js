import React, {useState} from 'react';
import './Login.css';
import axios from 'axios';

export default function Login(props) {
  const [loading, setLoading] = useState(false);
  const username = useFormInput('');
  const password = useFormInput('');
  const [error, setError] = useState(null);

  const handleLogin = (e) => {
    e.preventDefault();
    setError(null);
    setLoading(true);
    axios.post(`http://localhost:8080/api/v1/unsafe/user/login?username=${username.value}&password=${password.value}`)
    .then(response => {
      setLoading(false);
      console.log("------------data: " + response.data.length);
      if(response.data.length == 0){
        setError("Authentication Failed!");
      } else{
        props.history.push('/dashboard');
      }
      //setUserSession(response.data.token, response.data.user);
      //props.history.push('/dashboard');
    })
    .catch(error => {
      setLoading(false);
      console.log(error.response);
      setError("Something went wrong. Please try again later.");
    });
  }

   const handleLoginSafe = (e) => {
    e.preventDefault();
    setError(null);
    setLoading(true);
    axios.post(`http://localhost:8080/api/v1/safe/user/login?username=${username.value}&password=${password.value}`)
    .then(response => {
      setLoading(false);
      console.log("------------data: " + response.data.length);
      if(response.data.length == 0){
        setError("Authentication Failed!");
      } else{
        props.history.push('/dashboard');
      }
      //setUserSession(response.data.token, response.data.user);
      //props.history.push('/dashboard');
    })
    .catch(error => {
      setLoading(false);
      console.log(error.response);
      setError("Something went wrong. Please try again later.");
    });
  }

  return(
    <div className="Auth-form-container">
      <form className="Auth-form">
        <div className="Auth-form-content">
          <h3 className="Auth-form-title">Sign In</h3>
          <div className="form-group mt-3">
            <label>Username</label>
            <input
              type="text"
              {...username}
              className="form-control mt-1"
              placeholder="Enter username"
            />
          </div>
          <div className="form-group mt-3">
            <label>Password</label>
            <input
              type="password"
              {...password}
              className="form-control mt-1"
              placeholder="Enter password"
            />
            {error && <><small style={{ color: 'red' }}>{error}</small><br /></>}<br />
          </div>
          <div className="d-grid gap-2 mt-3">
            {/* <button type="submit" className="btn btn-primary">
              Submit
            </button> */}
            <input type="button" value={loading ? 'Loading...' : 'Login Un-safe Test'} onClick={handleLogin} disabled={loading} /><br />
           <input type="button" value={loading ? 'Loading...' : 'Login Safe Test'} onClick={handleLoginSafe} disabled={loading} /><br />
          </div>
        </div>
      </form>
    </div>
  )

  function useFormInput(initialValue) {
    const [value, setValue] = useState(initialValue)
  
    function handleChange(e) {
      setValue(e.target.value)
    }
  
    return {
      value,
      onChange: handleChange
    }
  }
}