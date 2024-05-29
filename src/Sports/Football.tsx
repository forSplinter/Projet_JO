import React from 'react';
import { Link } from 'react-router-dom';
import logo1 from'../assets/logo/logo1.png';//On met .. pour chercher le dossier assets dans le dossier src
import logo2 from'../assets/logo/logo2.png';
import footim from '../assets/imageSport/imagefootball.jpg';
import styles from './Sports.module.css';
const Football= () => {
  return (
    <div> 
        <header style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '10px' }}>
            <img src={logo2} alt="Logo 2" style={{ height: '70px',padding:'10px' }} className ='logo2' />
            <img src={logo1} alt="Logo 1" style={{ height: '100px',padding:'10px' }} className ='logo1' />
        </header>
        <div className={styles.titre}>
            <h2>Football</h2>
        </div>
        <div className={styles.foot}>
            <img src={footim} alt="football" style={{ height: '200px', borderRadius:'8%' }} />
            <p style={{ textAlign: 'justify' }}>In football, two teams compete to score goals by kicking a ball into the opposing 
            team's net. Each team consists of eleven players, including a goalkeeper, who defends the goalpost. Players use their feet,
            head, or body to control and pass the ball, but they cannot use their hands or arms, except for the goalkeeper within their 
            penalty area. The game is played in two halves, each lasting 45 minutes, with additional time added for stoppages. 
            Fouls are penalized with free kicks or penalty kicks, and players can be cautioned or sent off for serious misconduct. 
            The team with the most goals at the end of the match wins.
            </p>
        </div>
        <div className={styles.titre2}>
            <h2>Scoreboard</h2>
        </div>
        <div className={styles.scoreboard}>
            <h3 className={styles.premier}>1ère place</h3>
            {/* Contenu pour le premier médaillé */}
            <input type="text" value="" disabled />
            <h3 className={styles.deuxieme}>2ème place</h3>
            {/* Contenu pour le deuxième médaillé */}
            <input type="text" value="" disabled />
            <h3 className={styles.troisieme}>3ème place</h3>
            {/* Contenu pour le troisième médaillé */}
            <input type="text" value="" disabled />
        </div><br/>
        <div className={styles.retourvisitor}>
            <Link to="/Visitor"><button>Back</button></Link>
        </div>
    </div>
  );
}

export default Football;