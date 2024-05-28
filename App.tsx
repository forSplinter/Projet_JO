import React from 'react'
import './App.css'
import { BrowserRouter as Router,Routes, Route } from 'react-router-dom';
import Home from './Home';
import Visitor from './Visitor';
import Badminton from './Sports/Badminton';
import Football from './Sports/Football';
import Volleyball from './Sports/Volleyball';
import Athlete from './Athlete';
import Organizer from './Organizer';

const App: React.FC = () => {
  return (
    <Router>
      <div>
        <Routes>
          <Route index element={<Home />} />
          <Route path="/Visitor" element={<Visitor />} />
          <Route path="/Volleyball" element={<Volleyball />} />
          <Route path="/Football" element={<Football />} />
          <Route path="/Badminton" element={<Badminton />} />
          <Route path="/Athlete" element={<Athlete />} />
          <Route path="/Organizer" element={<Organizer />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;