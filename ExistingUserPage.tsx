import React, { useState } from 'react';
import styles from './ExistingUserPage.module.css'; // Assurez-vous que le fichier CSS est correctement nommé et placé
import logo1 from './assets/logo1.png'; 
import logo2 from './assets/logo2.png';
import googleLogo from './assets/google.png'; 
import facebookLogo from './assets/facebook.png';
import appleLogo from './assets/apple.png';

const ExistingUserPage: React.FC = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    console.log(email, password);
  };

  return (
    <div className={styles.container}>
        <header style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '10px' }}>
        <img src={logo2} alt="Logo 2" style={{ height: '50px' }} />
        <img src={logo1} alt="Logo 1" style={{ height: '50px' }} />
        </header>
      <h1>Login</h1>
      <form onSubmit={handleLogin}>
        <input
          type="email"
          value={email}
          onChange={e => setEmail(e.target.value)}
          placeholder="Email"
          className={styles.input}
        />
        <input
          type="password"
          value={password}
          onChange={e => setPassword(e.target.value)}
          placeholder="Password"
          className={styles.input}
        />
        <button type="submit" className={styles.submitButton}>Log-in</button>

        <div className={styles.socialButtons}>
         <a href="https://olympics.com/fr/paris-2024" target="_blank" rel="noopener noreferrer" className={styles.socialButton}>
        <img src={googleLogo} alt="Google" />
        </a>
        <a href="https://www.facebook.com/actujeuxolympiques/?locale=fr_FR" target="_blank" rel="noopener noreferrer" className={styles.socialButton}>
        <img src={facebookLogo} alt="Facebook" />
        </a>
        <a href="https://www.apple.com" target="_blank" rel="noopener noreferrer" className={styles.socialButton}>
        <img src={appleLogo} alt="Apple" />
        </a>
        </div>
      </form>
        <p className={styles.centerText}>
        <a href="/forgot-password" className={styles.link}>Forgot Password?</a>
        </p>
    </div>
  );
};

export default ExistingUserPage;
