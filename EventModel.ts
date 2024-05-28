import axios from 'axios';

export const fetchEvents = async () => {
  try {
    const response = await axios.get('/api/events');
    return response.data;
  } catch (error) {
    throw error;
  }
};

export const createEvent = async (eventData) => {
  try {
    const response = await axios.post('/api/events', eventData);
    return response.data;
  } catch (error) {
    throw error;
  }
};

export const updateEvent = async (id, eventData) => {
  try {
    const response = await axios.put(`/api/events/${id}`, eventData);
    return response.data;
  } catch (error) {
    throw error;
  }
};

export const deleteEvent = async (id) => {
  try {
    await axios.delete(`/api/events/${id}`);
  } catch (error) {
    throw error;
  }
};
export const fetchAthletes = async () => {
    try {
      const response = await axios.get('/api/athletes');
      return response.data;
    } catch (error) {
      console.error('Error fetching athletes:', error);
      return [];
    }
  };
  export const assignAthleteToEvent = async (eventId, athleteId) => {
    try {
      const response = await axios.post('/api/event-assignments', { eventId, athleteId });
      return response.data;
    } catch (error) {
      throw error;
    }
  };



