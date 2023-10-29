import React, { Component } from 'react';
// import NavBar from '../../components/NavBar';
// import LeftBar from '../../components/LeftBar';
import Typography from '@mui/material/Typography';

class chat extends Component {
    render() {
        return (
            <div>                      <Typography
            style={{ color: '#C932C3' }}
            variant="h3"
            fontWeight="bold"
            marginTop={5}>
            AI Pet Assistant
          </Typography>
          <br></br>
            <div className="row">
                <div className='col-md-6'>
                    <iframe
                        src="https://fastgpt.run/chat/share?shareId=h5as6zo0o5zoo51mgus7islj"
                        width="600"
                        height="700">
                    </iframe>
                </div>
                <div className='col-md-3'>
                </div>
            </div>
            </div>
        );
    }
}

export default chat;