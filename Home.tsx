// HomePage.tsx

import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import './Home.css';
import logo1 from'./assets/logo1.png'
import logo2 from'./assets/logo2.png'


class Home extends Component {
    render(){
        return <div className='container'>
         
            <header style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '10px' }}>
                <img src={logo2} alt="Logo 2" style={{ height: '70px',padding:'10px' }} className ='logo2' />
                <img src={logo1} alt="Logo 1" style={{ height: '100px',padding:'10px' }} className ='logo1' />
            </header>
            <div className="block">
                <h1>Hello !</h1><br/>
                <div className='button-container'>
                    <a href = "/Organizer"><button>Organizer</button></a>
                </div>
                <div className='button-container'>
                    <a href = "/Athlete"><button>Athlete</button></a>
                </div>
                <div className='button-container'>
                    <a href = "/Visitor"><button>Visitor</button></a>
                </div>
            </div>
        </div>
        
    }
}

export default Home;