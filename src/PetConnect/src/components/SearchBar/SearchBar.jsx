import { useState } from "react";
import SearchOutlinedIcon from '@mui/icons-material/SearchOutlined';

import "./SearchBar.css";

export const SearchBar = ({ setResults }) => {
  const [input, setInput] = useState("");

  const fetchData = (value) => {
    const lowerCaseValue = value.toLowerCase();
    fetch("http://localhost:9090/articles")
      .then((response) => response.json())
      .then((json) => {
        const results = json.filter((article) => {
          return (
            //前端承担了一切.jpg 油管印度老哥都说筛选该由后端来做
            lowerCaseValue &&
            article &&
            article.petRescueTitle &&
            article.petRescueTitle.toLowerCase().includes(lowerCaseValue)
          );
        });
        setResults(results);
      });
  };

  const handleChange = (value) => {
    setInput(value);
    fetchData(value);
  };

  return (
    <div className="input-wrapper">
      <SearchOutlinedIcon id="search-icon" />
      <input
        placeholder="Type to search..."
        value={input}
        onChange={(e) => handleChange(e.target.value)}
      />
    </div>
  );
};