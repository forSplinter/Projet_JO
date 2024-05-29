import React from 'react';
import logo1 from'../assets/logo/logo1.png'//On met .. pour chercher le dossier assets dans le dossier src
import logo2 from'../assets/logo/logo2.png'
import volleyim from '../assets/imageSport/imagevolley.jpg'
import { Link } from 'react-router-dom';
import styles from './Sports.module.css';
const Volleyball = () => {
  return (
    <div className={styles.container}> 
        <header style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '10px' }}>
            <img src={logo2} alt="Logo 2" style={{ height: '70px',padding:'10px' }} className ='logo2' />
            <img src={logo1} alt="Logo 1" style={{ height: '100px',padding:'10px' }} className ='logo1' />
        </header>
        <div className={styles.titre}>
            <h2>Volleyball</h2>
        </div>
        <div className={styles.volley}>
            <img src={volleyim} alt="volleyball" style={{ height: '200px', borderRadius:'8%' }} />
            <p style={{ textAlign: 'justify' }}>Volleyball at the Olympics is a fast-paced team sport played between two teams of six players each,
             separated by a net. The objective is to score points by grounding the ball on the opponent's court or forcing them to make a mistake. 
             Players use a combination of techniques such as serving, passing, setting, attacking, and blocking to control the ball and outsmart their opponents. 
             Matches are played in sets, with each set won by the team that first reaches 25 points. If the match reaches a fifth set, it is played to 15 points. 
             Teams are allowed a limited number of substitutions and have specific rotations during play. The team that wins three out of five sets wins the match.
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

export default Volleyball;