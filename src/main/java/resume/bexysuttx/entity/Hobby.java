package resume.bexysuttx.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hobby")
public class Hobby extends AbstractEntity<Long> implements Serializable, Comparable<Hobby>, ProfileEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "HOBBY_ID_GENERATOR", sequenceName = "HOBBY_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOBBY_ID_GENERATOR")
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(nullable = false, length = 30)
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_profile", nullable = false)
	private Profile profile;

	@Transient
	private boolean selected;

	public Hobby(String name, boolean selected) {
		super();
		this.name = name;
		this.selected = selected;
	}

	public Hobby(String name) {
		super();
		this.name = name;
	}

	public Hobby() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	@Transient
	public String getCssClassName() {
		return name.replace(" ", "-").toLowerCase();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hobby other = (Hobby) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Hobby o) {
		if (o == null || getName() == null) {
			return 1;
		} else {
			return getName().compareTo(o.getName());
		}
	}

	@Override
	public String toString() {
		return String.format("Hobby [name=%s]", name);
	}

}
