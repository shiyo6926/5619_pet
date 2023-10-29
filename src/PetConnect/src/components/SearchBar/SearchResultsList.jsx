import "./SearchResultsList.css";
import Divider from '@mui/material/Divider'
import { useHistory } from 'react-router-dom';
import React from 'react';


export const SearchResultsList = ({ results }) => {

    const history = useHistory()
    const changeIndex = (param) => {
        localStorage.setItem('selectedIndex', 8);
        history.push(`/home/Rescue/${param}`);
        window.location.reload();
        history.push(`/home/Rescue/${param}`);
    }
  return (
    <div className="results-list">
      {results.map((result, id) => {
        return <div className="search-result" key={id} onClick={() => changeIndex(result.petRescueId)}>{result.petRescueTitle}<Divider /></div>;
      })}
    </div>
  );
};